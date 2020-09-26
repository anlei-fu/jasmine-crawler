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

        public Task CreateData(int downSystemSiteId, string file)
        {
            var sql =$"insert into data(down_system_site_id,data_file) values ({downSystemSiteId},'{file}');";
            return ExecuteAsync(sql);
        }

        public Task<int> GetDownSytemIdByDownSystemSiteId(int downSystemSiteId)
        {
            var sql = $"select down_system_id from down_system_site where id = {downSystemSiteId};";
            return QuerySingleAsync<int>(sql);
        }

        public Task<IEnumerable<DownSystemSite>> GetNeedSaveDataSitesAsync()
        {
            var sql = "select dss.id as Id,dss.down_system_id as DownSystemId " +
                      "from down_system_site dss " +
                      "join down_system ds  on ds.id = dss.down_system_id " +
                      "where ds.enable_status = 1 and dss.enable_status = 1;";

            return QueryAsync<DownSystemSite>(sql);
        }

        public Task SyncData(int taskId, int downSystemId, int downSystemSiteId, string dataFile)
        {
            var sql = $"update crawl_task " +
                      $"set " +
                      $"data_sync_status = 1, " +
                      $"data_sync_time = current_timestamp, " +
                      $"data_file = '{dataFile}' " +
                      $"where id = {taskId}; ";

            sql += $"update down_system_site " +
                   $"set data_sync_count = data_sync_count + 1 " +
                   $"where id ={downSystemId}; ";

            sql += $"update down_system " +
                   $"set data_sync_count = data_sync_count + 1 " +
                   $"where id = {downSystemId};";

            return ExecuteTransaction(sql);
        }

        public Task UpdateDataAsync(int downSystemSiteId, string file, int length, int total)
        {
            var sql = $"update data set length ={length} , total = {total},last_update_time =current_timestamp where down_system_site_id = {downSystemSiteId} and data_file ='{file}'";
            return ExecuteAsync(sql);
        }
    }
}
