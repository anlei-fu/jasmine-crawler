using Jasmine.DataStore.Model;
using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.DataStore.DbAccess
{
  public  interface IDownSystemSiteAccess
    {
        List<DownSystemSite> GetAll();

        void IncreseDataSyncCount(int id);

    }
}
