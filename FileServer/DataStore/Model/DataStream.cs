using Jasmine.Crawler.File.FileProvider;
using Jasmine.DataStore.Model.Request;
using Jasmine.DataStore.Service;
using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.IO;
using System.Text;
using System.Threading.Tasks;

namespace Jasmine.DataStore.Model
{
    public class DataStream
    {
        private FileStream _fileStream;

        private IFileProvider _fileProvider;

        private IDataEncoder _encoder;

        private ICompressor _compressor;

        private int _downSystemId;
        private int _downSystemSiteId;

        private string _currentFile;


        public async Task<bool> SaveAsync(SaveDataRequest req)
        {
            try
            {
                if (_fileStream == null)
                {
                    _fileStream = _fileProvider.GetFileStream(_currentFile);
                }

                var bt = _encoder.Encode(_compressor.Compress(Newtonsoft.Json.JsonConvert.SerializeObject(req.Data)));
                await _fileStream.WriteAsync(bt, 0, bt.Length);
                if (_fileStream.Length > 1000000)
                {
                    _fileStream = null;
                    _fileStream.Close();
                }

                return true;
            }
            catch (Exception ex)
            {

                _fileStream.Close();
                _fileStream = null;
                return false;
            }
        }

        internal Task CloseAsync()
        {
            throw new NotImplementedException();
        }

        private void CreateFile()
        {

        }
    }
}
