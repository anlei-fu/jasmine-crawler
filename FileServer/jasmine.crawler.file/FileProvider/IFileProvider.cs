using System.IO;
using System.Threading.Tasks;

namespace Jasmine.Crawler.File.FileProvider
{
    public interface IFileProvider
    {
        Task<string> Save(Stream stream, string extension);
    }
}
