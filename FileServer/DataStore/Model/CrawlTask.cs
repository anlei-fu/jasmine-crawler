using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.DataStore.Model
{
  public  class CrawlTask
    {
        public int Id { get; set; }

        public int DataSyncStatus { get; set; }

        public DateTime DataSyncTime { get; set; }

        public string DataFile { get; set; }
    }
}
