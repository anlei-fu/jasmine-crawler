using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.Crawler.Common.Model.Request
{
  public  class SaveDataRequest
    {
        [JsonProperty("taskId")]
        public int TaskId { get; set; }
        [JsonProperty("downSystemSiteId")]
        public int DownSystemSiteId { get; set; }
        [JsonProperty("data")]
        public List<string> Data { get; set; }
    }
}
