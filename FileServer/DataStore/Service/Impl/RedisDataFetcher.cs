using Jasmine.Crawl.Common.Logging;
using Jasmine.Crawler.Common.Model.Request;
using StackExchange.Redis;
using System;
using System.Threading.Tasks;

namespace Jasmine.DataStore.Service.Impl
{
    public class RedisDataFetcher :LoggerSurpport, IDataFetcher
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

                return Deserialize(value);
            }
            catch (Exception ex)
            {
                Error($"fetch site({downSystemSiteId}) data failed", ex);
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
                Error($"check dose site({downSystemSiteId}) has data failed", ex);
                return false;
            }
        }

        private SaveDataRequest Deserialize(RedisValue value)
        {
            if (!value.HasValue)
                return null;

            var str = value.ToString();
            str = str.Replace("\"@class\":\"com.jasmine.crawler.common.pojo.req.SaveTaskDataReq\",", "")
                   .Replace("[\"java.util.LinkedList\",", "")
                   .Replace("\"]],", "\"],");


            return Newtonsoft.Json.JsonConvert.DeserializeObject<SaveDataRequest>(str);
        }
    }
}
