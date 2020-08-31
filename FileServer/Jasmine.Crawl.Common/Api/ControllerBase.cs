using Jasmine.Crawl.Common.Constant;
using Jasmine.Crawl.Common.Model.Response;
using Jasmine.Crawler.Common.Model.Response;
using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.Crawl.Common.Api
{
    public class ControllerBase
    {
        public ApiBaseResponse ResponseBool(bool result)
        {
            return result ? Success() : Fail();
        }

        public ApiBaseResponse Success(string msg = "succeed")
        {
            return new ApiBaseResponse((int)ApiCode.SUCCESS, msg);
        }

        public ApiBaseResponse Fail(int code = (int)ApiCode.FAILED, string msg = "failed")
        {
            return new ApiBaseResponse(code, msg);
        }

        public ApiResponse<T> ResponseData<T>(T data, int failedCode = (int)ApiCode.FAILED, string failedMsg = "failed")
        {
            return data == null ?
                new ApiResponse<T>(data, failedCode, failedMsg) : new ApiResponse<T>(data, (int)ApiCode.SUCCESS, "succeed");
        }

    }
}
