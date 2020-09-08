using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace Jasmine.Crawl.Common.Utils
{
   public class FileUtils
    {
        public static T ReadJson<T>(string path)
        {
            return Newtonsoft.Json.JsonConvert.DeserializeObject<T>(File.ReadAllText(path));
        }

        public static void WriteJson(string path,object data)
        {
            File.WriteAllText(path, Newtonsoft.Json.JsonConvert.SerializeObject(data));
        }
    }
}
