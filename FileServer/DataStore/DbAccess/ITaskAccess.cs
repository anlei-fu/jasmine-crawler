using Jasmine.DataStore.Model;
using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.DataStore.DbAccess
{
    interface ITaskAccess
    {
        void SyncData(int id, string file);
    }
}
