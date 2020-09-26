using Jasmine.Crawl.Common.Utils;
using log4net;
using System;
using System.IO;
using System.Threading.Tasks;

namespace Jasmine.Crawler.File.FileProvider
{
    public class FileProviderImpl : IFileProvider
    {

        private ILog _logger = LogManager.GetLogger(typeof(FileProviderImpl));

        private string _targetFolder;

        public FileProviderImpl(string targetFolder)
        {
            this._targetFolder = targetFolder ?? throw new ArgumentNullException(nameof(targetFolder));
        }

        public FileStream GetFileStream(string fileName)
        {
            var index = fileName.LastIndexOf("/");
            var directory =_targetFolder+ fileName.Substring(0, index);
            Directory.CreateDirectory(directory);
            return new FileStream(_targetFolder+fileName,FileMode.Create,FileAccess.Write);
        }

        public async Task<string> Save(Stream stream, string extension)
        {
            var key = RandomUtils.MakeRandomString(4);
            using (var fileStream = new FileStream($"{_targetFolder}/{key}.{extension}", FileMode.OpenOrCreate, FileAccess.Write))
            {
                try
                {
                    await stream.CopyToAsync(fileStream);
                    return key +"."+ extension;
                }
                catch (Exception ex)
                {
                    _logger.Error(ex);
                    throw ex;
                }
            }
        }
    }
}
