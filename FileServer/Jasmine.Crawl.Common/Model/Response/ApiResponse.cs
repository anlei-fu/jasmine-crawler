using Jasmine.Crawl.Common.Model.Response;
using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.Crawler.Common.Model.Response
{ 
  public  class ApiResponse<T>:ApiBaseResponse
    {
        public ApiResponse(T data,int code,string msg)
            :base(code,msg)
        {
            Data = data;
        }

        public T Data { get; set; }
    }
}
