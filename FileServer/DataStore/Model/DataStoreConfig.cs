using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.DataStore.Model
{
  public  class DataStoreConfig
    {
        public string SqlConnectionString { get; set; }
        public string RedisConnectionString { get; set; }
        public int ScheduleMinSpeed { get; set; } = 1000;

        public int ScheduleMaxSpeed { get; set; } = 60 * 1000;

        public int MaxSaveTask { get; set; } = 10;

        public int DataFileMaxSize { get; set; } = 1024 * 1024 * 20;

    }
}
