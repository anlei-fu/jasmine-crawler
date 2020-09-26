using Jasmine.Crawl.Common.Logging;
using Jasmine.Crawl.Common.Utils;
using Jasmine.Crawler.File.FileProvider;
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
    public class DataSaveJob : LoggerSurpport
    {
        private readonly ConcurrentDictionary<int, int> _savingDownSystemSite = new ConcurrentDictionary<int, int>();

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
            Info("initializing...");
            Init();
            Info("started!");
            while (true)
            {
                Info("begin data saving job");
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
                        Error($"get sites from db failed ", ex);
                        continue;
                    }

                    if (sites != null)
                    {
                        hasDataToSave = await SaveCore(sites);
                    }
                    else
                    {
                        Info($"no sites need save data, and current task count is {_savingDownSystemSite.Count}");
                    }
                }

                var delay = _delayCaculator.NextDelay(hasDataToSave);
                Info($"job next fire will be {DateTime.Now.AddMilliseconds(delay)}");
                Thread.Sleep(delay);
            }
        }

        public void FinishTask(int downSystemSiteId)
        {
            Info($"finish site({downSystemSiteId}) data save task");
            _savingDownSystemSite.TryRemove(downSystemSiteId, out var _);
        }

        private void Init()
        {
            DataFetcher = new RedisDataFetcher(ConnectionMultiplexer.Connect(_dataStoreConfig.RedisConnectionString).GetDatabase());
            //DataFetcher = new MockDataFeatcher();
            DataAccess = new DataAccessImpl(_dataStoreConfig.SqlConnectionString);

            DataSaverProvider = new DataSaverProviderImpl(
                DataAccess,
                new FileProviderImpl("d:/test/"),
                _dataStoreConfig.DataFileMaxSize,
                _dataStoreConfig.DataSaverInactiveTimeout,
                _dataStoreConfig.DataSaverCleanInterval);

            _delayCaculator = new DelacaculatorImpl(_dataStoreConfig.ScheduleMaxSpeed, _dataStoreConfig.ScheduleMinSpeed);

            ((DataSaverProviderImpl)DataSaverProvider).Init();
        }

        private async Task<bool> SaveCore(IEnumerable<DownSystemSite> sites)
        {
            var hasDataToSave = false;
            var t = 0;
            foreach (var downSystemSite in sites)
            {
                try
                {
                    if (_savingDownSystemSite.ContainsKey(downSystemSite.Id))
                        continue;

                    if (await DataFetcher.HasData(downSystemSite.Id))
                    {
                        hasDataToSave = true;
                        var task = new SaveDataTask(downSystemSite.DownSystemId, downSystemSite.Id, this);
                        Task.Run(task.Save);
                        t++;
                        Info($"start saving site({downSystemSite.Id}) data task");

                        _savingDownSystemSite.TryAdd(downSystemSite.Id, 1);
                        if (_savingDownSystemSite.Count > _dataStoreConfig.MaxSaveTask)
                            break;
                    }
                }
                catch (Exception ex)
                {
                    Error($"save site({downSystemSite.Id}) failed", ex);
                }
            }

            Info($"get {t} site to save data, and current task count is {_savingDownSystemSite.Count}");

            return hasDataToSave;
        }
    }
}
