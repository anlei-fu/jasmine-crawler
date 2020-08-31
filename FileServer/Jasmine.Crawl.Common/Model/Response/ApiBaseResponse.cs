using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.Crawl.Common.Model.Response
{
   public class ApiBaseResponse
    {
        public ApiBaseResponse(int code, string msg) {
            Code = code;
            Message = msg;
        }
        public int Code { get; set; }
        public string Message { get; set; }
    }
}
