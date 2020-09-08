using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.Crawl.Common.Utils
{
  public  class RandomUtils
    {
        public static string MakeRandomString(int length)
        {
            var rd = new Random();
            var t = 0;
            var key = string.Empty;
            while (t<length)
            {
                key += rd.Next(0, 9).ToString();
                ++t;
            }

            return key;
        }
    }
}
