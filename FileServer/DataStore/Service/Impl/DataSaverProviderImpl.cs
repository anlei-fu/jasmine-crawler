using Jasmine.Crawler.File.FileProvider;
using Jasmine.DataStore.Model;
using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.DataStore.Service.Impl
{
    public class DataSaverProviderImpl : IDataSaverProvider
    {
        private IDataEncoder _dataEncoder = new LengthFieldDataEncoder();

        private ICompressor _compressor = new GZipCompressor();

        private IFileProvider _fileProvider;

        private int _dataFileMaxSize;

        public DataSaverProviderImpl(IFileProvider fileProvider,int dataFileMaxSize)
        {
            _fileProvider = fileProvider;
            _dataFileMaxSize = dataFileMaxSize;
        }

        public DataFileSaver GetDataStream(int downSystemId, int downSystemSiteId)
        {
            return new DataFileSaver(_fileProvider, _dataEncoder, _compressor, downSystemId, downSystemSiteId,_dataFileMaxSize);
        }
    }
}
