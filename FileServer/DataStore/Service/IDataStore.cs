using Jasmine.DataStore.Model.Request;
using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.DataStore.Service
{
    interface IDataStore
    {
        bool Save(SaveDataRequest saveDataRequest);
    }
}
