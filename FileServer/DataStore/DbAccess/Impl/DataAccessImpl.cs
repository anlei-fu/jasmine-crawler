using Jasmine.DataStore.Model;
using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.DataStore.DbAccess.Impl
{
    public class DataAccessImpl : IDataAccess
    {
        public bool Add(Data data)
        {
            using (var context = new DataContext())
            {
                context.Data.Add(null);
                context.Data.Update(null);
                context.SaveChanges();
            }

            return true;
        }
    }
}
