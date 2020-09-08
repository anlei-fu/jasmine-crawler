using Jasmine.Crawler.File.FileProvider;
using Jasmine.Crawler.File.Model;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using System.IO;
using System.Threading.Tasks;

namespace FileServer.Controller
{
    [ApiController]
    public class FileController : ControllerBase
    {
        private IFileProvider _fileProvider;

        public FileController(IConfiguration config)
        {
            this._fileProvider = new FileProviderImpl(config.GetSection("TargetFolder").Value);
        }

        [HttpGet("/test")]
        public string Say()
        {
            return "ok";
        }

        [HttpPost("/uploadFile")]
        public Task<SaveFileResult> UploadFile(string ext)
        {
            var result = new SaveFileResult();

            if (Request.Form.Files.Count == 0)
            {
                result.Message = "no file to save";
                result.Result = false;
                return Task.FromResult(result);
            }

            return SaveCore(Request.Form.Files[0].OpenReadStream(), ext);
        }

        [HttpPost("/upload")]
        public Task<SaveFileResult> Upload(string ext)
        {
            return SaveCore(Request.Body, ext);
        }

        private async Task<SaveFileResult> SaveCore(Stream s, string ext)
        {

            var result = new SaveFileResult();
            try
            {

                if (string.IsNullOrWhiteSpace(ext))
                {
                    result.Message = "parameter 'ext' can not be null";
                    result.Result = false;
                }
                else
                {

                    result.Key = await _fileProvider.Save(s, ext);
                    result.Result = true;
                    result.Message = "success";
                }
            }
            catch
            {
                result.Message = "server error";
                result.Result = false;
            }

            return result;
        }
    }
}
