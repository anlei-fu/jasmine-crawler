using Jasmine.Crawler.Common.Model.Request;
using StackExchange.Redis;
using System;
using System.Threading.Tasks;

namespace Jasmine.DataStore.Service.Impl
{
    public class RedisDataFetcher : IDataFetcher
    {
        private IDatabase _db;

        public RedisDataFetcher(IDatabase database)
        {
            _db = database;
        }

        public async Task<SaveDataRequest> FetchAsync(int downSystemSiteId)
        {
            try
            {
                var value = await _db.ListRightPopAsync($"data_queue_{downSystemSiteId}");
                return value.HasValue ? Newtonsoft.Json.JsonConvert.DeserializeObject<SaveDataRequest>(value.ToString()) : null;

            }
            catch (Exception ex)
            {
                return null;
            }
        }

        public async Task<bool> HasData(int downSystemSiteId)
        {
            try
            {
                return await _db.ListLengthAsync($"data_queue_{downSystemSiteId}") > 0;
            }
            catch (Exception ex)
            {
                return false;
            }
        }
    }
}
