﻿using Jasmine.DataStore.Model;
using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.DataStore.DbAccess
{
    interface IDataAccess
    {
        bool Add(Data data );
    }
}
