using Jasmine.DataStore.DbAccess;
using Jasmine.DataStore.Model;
using Jasmine.DataStore.Model.Request;
using Jasmine.DataStore.Service.Impl;
using StackExchange.Redis;
using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Jasmine.DataStore.Service
{
  public  class DataSaveJob
    {
        private ConcurrentDictionary<int, int> _savingDownSystemSite;
        public IDatabase Db { get; set; }
        public IDataStreamManager DataStreamManager { get; set; }
        public IDownSystemSiteAccess DownSystemSiteAccess { get; set; }

        public void Schedule()
        {
            while (true)
            {
                if (_savingDownSystemSite.Count < 10)
                {
                    List<DownSystemSite> sites = null;
                    try
                    {
                        sites = DownSystemSiteAccess.GetAll();
                        foreach (var item in sites)
                        {
                            var task = new SaveDataTask(item.DownSystemId, item.Id);
                            Task.Run(task.Save);
                            if (_savingDownSystemSite.Count > 10)
                                break;
                        }

                    }catch(Exception ex)
                    {

                    }
                }

                Thread.Sleep(10000);
            }
        }

        public void FinishTask(int downSystemSiteId)
        {
            _savingDownSystemSite.TryRemove(downSystemSiteId, out var _);
        }
     
    }
}
