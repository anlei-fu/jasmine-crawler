using Jasmine.DataStore.Model;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace Jasmine.DataStore.DbAccess.Impl
{
    public class DataAccessImpl : AccessBase, IDataAccess
    {
        public DataAccessImpl(string connectionString) : base(connectionString)
        {
        }

        public Task<int> GetDownSytemIdByDownSystemSiteId(int downSystemSiteId)
        {
            var sql = $"select down_system_id from down_system_site where id = {downSystemSiteId};";
            return QuerySingleAsync<int>(sql);
        }

        public Task<IEnumerable<DownSystemSite>> GetNeedSaveDataSitesAsync()
        {
            var sql = "select id,down_system_id " +
                      "from down_system_site dss" +
                      "join down_system ds  on ds.id = dss.down_system_id" +
                      "where ds.enable_status = 1 and dss.enable_status = 1";

            return QueryAsync<DownSystemSite>(sql);
        }

        public Task SyncData(int taskId, int downSystemId, int downSystemSiteId, string dataFile)
        {
            var sql = $"update crawl_task" +
                      $"set" +
                      $"data_sync_status = 1," +
                      $"data_sync_time = {DateTime.Now}," +
                      $"data_file = file" +
                      $"where id = {taskId};";

            sql += $"update down_system_site " +
                   $"set data_sysnc_dount = data_sync_count + 1" +
                   $"where id ={downSystemId};";

            sql += $"update down_system" +
                   $"set data_sysnc_count = data_sync_count + 1" +
                   $"where id = {downSystemId};";

            return ExecuteTransaction(sql);
        }
    }
}
