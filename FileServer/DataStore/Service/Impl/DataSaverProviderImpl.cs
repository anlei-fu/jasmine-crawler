using Jasmine.Crawl.Common.Logging;
using Jasmine.Crawler.File.FileProvider;
using Jasmine.DataStore.DbAccess;
using Jasmine.DataStore.Model;
using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Jasmine.DataStore.Service.Impl
{
    public class DataSaverProviderImpl : LoggerSurpport, IDataSaverProvider
    {
        private readonly ConcurrentDictionary<int, DataFileSaver> _cache = new ConcurrentDictionary<int, DataFileSaver>();

        private readonly IDataEncoder _dataEncoder = new LengthFieldDataEncoder();

        private readonly ICompressor _compressor = new GZipCompressor();

        private readonly IFileProvider _fileProvider;

        private readonly IDataAccess _dataAccess;

        private readonly int _dataFileMaxSize;

        private readonly int _saverInactiveTimeout;

        private readonly int _clearSaverInterval;

        public DataSaverProviderImpl(IDataAccess dataAccess,IFileProvider fileProvider, int dataFileMaxSize, int saverInactiveTimeout, int clearSaverInterval)
        {
            _dataAccess = dataAccess;
            _fileProvider = fileProvider;
            _dataFileMaxSize = dataFileMaxSize;
            _saverInactiveTimeout = saverInactiveTimeout;
            _clearSaverInterval = clearSaverInterval;


        }

        public void Init()
        {
            Task.Factory.StartNew(() =>
            {
                while (true)
                {
                    foreach (var item in _cache)
                    {
                        if (item.Value.LastActive.AddMinutes(_saverInactiveTimeout) < DateTime.Now)
                        {
                            _cache.TryRemove(item.Key, out var saver);
                            saver.Close();
                            Info($"close data saver(${item.Key})");
                        }
                    }

                    Thread.Sleep(_clearSaverInterval * 60 * 1000);
                }

            }, TaskCreationOptions.LongRunning);
        }

        public DataFileSaver GetDataSaver(int downSystemId, int downSystemSiteId)
        {
            if (_cache.TryGetValue(downSystemSiteId, out var result))
                return result;

            var saver = new DataFileSaver(
                _dataAccess,
                _fileProvider,
                _dataEncoder, _compressor,
                downSystemId, downSystemSiteId
                , _dataFileMaxSize);

            _cache.TryAdd(downSystemSiteId, saver);

            return saver;
        }

    }
}
