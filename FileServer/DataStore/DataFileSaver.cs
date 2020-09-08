using Jasmine.Crawl.Common.Utils;
using Jasmine.Crawler.Common.Model.Request;
using Jasmine.Crawler.File.FileProvider;
using Jasmine.DataStore.Service;
using System;
using System.IO;
using System.Threading.Tasks;

namespace Jasmine.DataStore.Model
{
    public class DataFileSaver
    {
        private IFileProvider _fileProvider;

        private IDataEncoder _encoder;

        private ICompressor _compressor;

        private int _downSystemId;

        private int _downSystemSiteId;

        private int _dataFileMaxSize;

        private FileStream _fileStream;

        public DataFileSaver(IFileProvider fileProvider, IDataEncoder encoder, ICompressor compressor, int downSystemId, int downSystemSiteId, int dataFileMaxSize)
        {
            _fileProvider = fileProvider;
            _encoder = encoder;
            _compressor = compressor;
            _downSystemId = downSystemId;
            _downSystemSiteId = downSystemSiteId;
            _dataFileMaxSize = dataFileMaxSize;
        }

        public string CurrentFile { get; private set; }

        public async Task<bool> SaveAsync(SaveDataRequest req)
        {
            try
            {
                if (_fileStream == null)
                {
                    CreateFile();
                    _fileStream = _fileProvider.GetFileStream(CurrentFile);
                }

                var bt = _encoder.Encode(_compressor.Compress(Newtonsoft.Json.JsonConvert.SerializeObject(req.Data)));
                await _fileStream.WriteAsync(bt, 0, bt.Length);

                if (_fileStream.Length > _dataFileMaxSize)
                    Close();

                return true;
            }
            catch (Exception ex)
            {
                Close();
                return false;
            }
        }

        public void Close()
        {
            try
            {
                if (_fileStream != null)
                {
                    _fileStream.Close();
                    _fileStream = null;
                }
            }
            catch (Exception ex)
            {

            }
        }

        private void CreateFile()
        {
            CurrentFile = $"/{_downSystemId}/${_downSystemSiteId}/{DateTime.Now.ToString("yyyyMMddHHmmss")}{RandomUtils.MakeRandomString(4)}.data";
        }
    }
}
