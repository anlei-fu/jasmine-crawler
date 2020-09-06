using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.DataStore.Model.Request
{
  public  class SaveDataRequest
    {
        public int TaskId { get; set; }
        public int DownSystemSiteId { get; set; }
        public List<string> Data { get; set; }
    }
}
