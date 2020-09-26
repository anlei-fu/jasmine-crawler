using Jasmine.DataStore.Model;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace Jasmine.DataStore.DbAccess
{
    public interface IDataAccess
    {
        Task SyncData(int taskId, int downSystemId, int downSystemSiteId, string dataFile);
        Task<int> GetDownSytemIdByDownSystemSiteId(int downSystemSiteId);

        Task<IEnumerable<DownSystemSite>> GetNeedSaveDataSitesAsync();

        Task CreateData(int downSystemSiteId, string file);

        Task UpdateDataAsync(int downSystemSiteId, string file, int length, int total);
    }
}
