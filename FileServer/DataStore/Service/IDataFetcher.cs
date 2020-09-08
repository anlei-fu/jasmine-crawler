using Jasmine.Crawler.Common.Model.Request;
using System.Threading.Tasks;

namespace Jasmine.DataStore.Service
{
    public interface IDataFetcher
    {
       Task<SaveDataRequest> FetchAsync(int downSystemSiteId);

        Task<bool> HasData(int downSystemSiteId);
    }
}
