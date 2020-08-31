using Jasmine.Crawler.File.FileProvider;
using Jasmine.DataStore.Model.Request;
using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.DataStore.Service.Impl
{
    public class DataFileStoreImpl : IDataStore
    {
        private IFileProvider _filprovider;

        private ConcurrentDictionary<int, ConcurrentQueue<SaveDataRequest>> _queues = new ConcurrentDictionary<int, ConcurrentQueue<SaveDataRequest>>();
        public bool Save(SaveDataRequest saveDataRequest)
        {
            throw new NotImplementedException();
        }
    }
}
