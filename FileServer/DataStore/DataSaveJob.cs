using Jasmine.Crawl.Common.Utils;
using Jasmine.DataStore.DbAccess;
using Jasmine.DataStore.DbAccess.Impl;
using Jasmine.DataStore.Model;
using Jasmine.DataStore.Service.Impl;
using StackExchange.Redis;
using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.Linq;
using System.Threading;
using System.Threading.Tasks;

namespace Jasmine.DataStore.Service
{
    public class DataSaveJob
    {
        private readonly ConcurrentDictionary<int, int> _savingDownSystemSite;

        private readonly DataStoreConfig _dataStoreConfig;

        private IDelayCaculator _delayCaculator;

        public DataSaveJob(string configFile)
        {
            _dataStoreConfig = FileUtils.ReadJson<DataStoreConfig>(configFile);
        }

        internal IDataFetcher DataFetcher { get; private set; }

        internal IDataSaverProvider DataSaverProvider { get; private set; }
        
        internal IDataAccess DataAccess { get; private set; }

        public async void Run()
        {
            Init();

            while (true)
            {
                var hasDataToSave = false;
                if (_savingDownSystemSite.Count < _dataStoreConfig.MaxSaveTask)
                {
                    IEnumerable<DownSystemSite> sites = null;
                    try
                    {
                        sites = await DataAccess.GetNeedSaveDataSitesAsync();
                      
                    }
                    catch (Exception ex)
                    {
                        continue;
                    }

                    if (sites != null)
                    {
                        hasDataToSave = await SaveCore(sites);
                    }
                    else
                    {

                    }
                  
                }

                Thread.Sleep(_delayCaculator.NextDelay(hasDataToSave));
            }
        }

        public void FinishTask(int downSystemSiteId)
        {
            _savingDownSystemSite.TryRemove(downSystemSiteId, out var _);
        }

        private void Init()
        {
            DataFetcher = new RedisDataFetcher(ConnectionMultiplexer.Connect(_dataStoreConfig.RedisConnectionString).GetDatabase());
            DataSaverProvider = new DataSaverProviderImpl(null, _dataStoreConfig.DataFileMaxSize);
            DataAccess = new DataAccessImpl(_dataStoreConfig.SqlConnectionString);
        }

        private async Task<bool> SaveCore(IEnumerable<DownSystemSite> sites)
        {
            var hasDataToSave = false;
            foreach (var downSystemSite in sites)
            {
                try
                {
                    if (await DataFetcher.HasData(downSystemSite.Id))
                    {
                        hasDataToSave = true;
                        var task = new SaveDataTask(downSystemSite.DownSystemId, downSystemSite.Id, this);
                        await Task.Run(task.Save);

                        if (_savingDownSystemSite.Count > _dataStoreConfig.MaxSaveTask)
                            break;
                    }
                }
                catch (Exception ex)
                {

                }
            }

            return hasDataToSave;
        }


    }
}
