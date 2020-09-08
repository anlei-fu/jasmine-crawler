using Jasmine.DataStore.Model;
using System;

namespace Jasmine.DataStore.Service
{
    public class SaveDataTask
    {
        private readonly int _downSystemId;

        private readonly int _downSystemSiteId;

        private DataSaveJob _dataSaveJob;

        private DataFileSaver _stream;

        public SaveDataTask(int downSystemId, int downSystemSiteId, DataSaveJob dataSaveJob)
        {
            _downSystemId = downSystemId;
            _downSystemSiteId = downSystemSiteId;
            _dataSaveJob = dataSaveJob;
        }

        public async void Save()
        {
            try
            {
                _stream = _dataSaveJob.DataSaverProvider.GetDataStream(_downSystemId, _downSystemSiteId);
            }
            catch (Exception ex)
            {
                Finish();
                return;
            }

            while (true)
            {
                try
                {
                    var req = await _dataSaveJob.DataFetcher.FetchAsync(_downSystemSiteId);
                    if (req == null)
                    {
                        Finish();
                        return;
                    }

                    await _stream.SaveAsync(req);
                    await _dataSaveJob.DataAccess.SyncData(req.TaskId, _downSystemId, req.DownSystemSiteId, _stream.CurrentFile);
                }
                catch (Exception ex)
                {
                    Finish();
                    return;
                }
            }
        }

        private void Finish()
        {
            if (_stream != null)
                _stream.Close();

            _dataSaveJob.FinishTask(_downSystemSiteId);
        }
    }
}
