using Jasmine.Crawl.Common.Logging;
using Jasmine.Crawl.Common.Utils;
using Jasmine.Crawler.Common.Model.Request;
using Jasmine.Crawler.File.FileProvider;
using Jasmine.DataStore.DbAccess;
using Jasmine.DataStore.Service;
using System;
using System.IO;
using System.Threading.Tasks;

namespace Jasmine.DataStore.Model
{
    public class DataFileSaver : LoggerSurpport
    {
        private readonly IFileProvider _fileProvider;

        private readonly IDataEncoder _encoder;

        private readonly ICompressor _compressor;

        private readonly IDataAccess _dataAccess;

        private readonly int _downSystemId;

        private readonly int _downSystemSiteId;

        private readonly int _dataFileMaxSize;

        private FileStream _fileStream;

        private string _currentFile;

        private int _total = 0;

        public DataFileSaver(
            IDataAccess dataAccess,
            IFileProvider fileProvider,
            IDataEncoder encoder,
            ICompressor compressor,
            int downSystemId,
            int downSystemSiteId,
            int dataFileMaxSize)
        {
            _dataAccess = dataAccess;
            _fileProvider = fileProvider;
            _encoder = encoder;
            _compressor = compressor;
            _downSystemId = downSystemId;
            _downSystemSiteId = downSystemSiteId;
            _dataFileMaxSize = dataFileMaxSize;
        }

        public DateTime LastActive { get; private set; }

        public async Task<bool> SaveAsync(SaveDataRequest req)
        {
            try
            {
                if (_fileStream == null)
                {
                    CreateFile();
                    try
                    {
                        _fileStream = _fileProvider.GetFileStream(_currentFile);
                        await _dataAccess.CreateData(_downSystemSiteId, _currentFile);
                    }
                    catch (Exception ex)
                    {
                        Error($"get file stream({_currentFile}) failed", ex);
                        Close();
                        return false;
                    }
                }

                var bt = _encoder.Encode(_compressor.Compress(Newtonsoft.Json.JsonConvert.SerializeObject(req.Data)));
                await _fileStream.WriteAsync(bt, 0, bt.Length);
                await _dataAccess.SyncData(req.TaskId, _downSystemId, req.DownSystemSiteId,_currentFile);

                _total += req.Data.Count;
                await _dataAccess.UpdateDataAsync(_downSystemSiteId, _currentFile, (int)_fileStream.Length, _total);
                await _fileStream.FlushAsync();

                Info($"save data [site:{_downSystemSiteId},taskId:{req.TaskId},total:{_total},length:{_fileStream.Length}]");

                LastActive = DateTime.Now;
                if (_fileStream.Length > _dataFileMaxSize)
                {
                    Info("close file ,cause over max size");
                    _total = 0;
                    Close();
                }

                return true;
            }
            catch (Exception ex)
            {
                Error($"site({req.DownSystemSiteId},{req.TaskId}) failed", ex);
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
                Error($"close file[{_currentFile}] failed", ex);
            }
        }

        private void CreateFile()
        {
            _currentFile = $"/{_downSystemId}/{_downSystemSiteId}/{DateTime.Now.ToString("yyyyMMddHHmmss")}{RandomUtils.MakeRandomString(4)}.data";
            Info($"create new file[{_currentFile}]");
        }
    }
}
