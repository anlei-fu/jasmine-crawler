using Jasmine.DataStore.Model;
using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.DataStore.Service.Impl
{
  public  interface IDataStreamManager
    {
       DataStream GetDataStream(int downSystemId,int downSystemSiteId);
    }
}
