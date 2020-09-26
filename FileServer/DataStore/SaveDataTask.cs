using Jasmine.Crawl.Common.Logging;
using Jasmine.DataStore.Model;
using System;

namespace Jasmine.DataStore.Service
{
    public class SaveDataTask : LoggerSurpport
    {
        private readonly int _downSystemId;

        private readonly int _downSystemSiteId;

        private readonly DataSaveJob _dataSaveJob;

        private DataFileSaver _dataSaver;

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
                _dataSaver = _dataSaveJob.DataSaverProvider.GetDataSaver(_downSystemId, _downSystemSiteId);
            }
            catch (Exception ex)
            {
                Error($"get data stream for site({_downSystemId}) failed", ex);
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
                        Info($"no more data to save of site({_downSystemSiteId})");
                        Finish();
                        return;
                    }

                    await _dataSaver.SaveAsync(req);
                }
                catch (Exception ex)
                {
                    Error($"site({_downSystemId}) save data failed", ex);
                    Finish();
                    return;
                }
            }
        }

        private void Finish()
        {
            _dataSaveJob.FinishTask(_downSystemSiteId);
        }
    }
}
