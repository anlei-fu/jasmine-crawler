using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.DataStore.Model
{
  public  class Data
    {
        public int Id { get; set; }
        public int DownSystemSiteId { get; set; }
        public int Length { get; set; }
        public int Total { get; set; }

        public string Path { get; set; }

        public DateTime CreateTime { get; set; }
    }
}
