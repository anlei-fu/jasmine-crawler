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
        public async Task<string> Save(Stream stream, string extension)
        {
            var key = RandomKey();
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

        private string RandomKey() {
            var rd = new Random();
            var key = DateTime.Now.ToString("yyyyMMddHHmmss");
            for (int i = 0; i < 4; i++)
                key+= rd.Next(1, 9).ToString();

            return key;
        
        }
    }
}
