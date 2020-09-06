using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.DataStore.DbAccess
{
    interface IDonwSystemAccess
    {
        void IncreaseDataSyncCount(int id);
    }
}
