using Jasmine.DataStore.Model;
using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.DataStore.Service.Impl
{
  public  interface IDataSaverProvider
    {
       DataFileSaver GetDataSaver(int downSystemId,int downSystemSiteId);
    }
}
