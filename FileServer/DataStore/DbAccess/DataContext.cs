using Jasmine.DataStore.Model;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.DataStore.DbAccess
{
   public class DataContext :DbContext
    {
        public DbSet<Data> Data { get; set; }
    }
}
