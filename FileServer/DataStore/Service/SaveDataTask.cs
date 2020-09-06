using Jasmine.DataStore.Model.Request;
using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.DataStore.Service
{
   public class SaveDataTask
    {
        private int _downSystemId;

        private int _downSystemSiteId;

        private int _taskId;

        private DataSaveJob _dataSaveJob;

        public SaveDataTask(int downSystemId,int downSystemSiteId)
        {
            _downSystemId = downSystemId;
            _downSystemSiteId = downSystemSiteId;
        }

        public async void Save()
        {
            var stream = _dataSaveJob.DataStreamManager.GetDataStream(_downSystemId, _downSystemSiteId);
            while (true)
            {
                try
                {
                    var value = _dataSaveJob.Db.ListRightPop(string.Format("data_{0}_{1}", _downSystemId, _downSystemSiteId));
                    if (!value.HasValue)
                    {
                        _dataSaveJob.FinishTask(_downSystemSiteId);
                        await stream.CloseAsync();
                    }
                    var req = Newtonsoft.Json.JsonConvert.DeserializeObject<SaveDataRequest>(value.ToString());
                    await stream.SaveAsync(req);
                    SyncData(req);
                }
                catch (Exception ex)
                {
                    await stream.CloseAsync();
                    _dataSaveJob.FinishTask(_downSystemSiteId);
                }
            }
        }

        private void SyncData(SaveDataRequest req)
        {

        }
    }
}
