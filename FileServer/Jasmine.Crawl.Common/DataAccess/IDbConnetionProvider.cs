using System;
using System.Collections.Generic;
using System.Data;
using System.Text;
using System.Threading.Tasks;

namespace Jasmine.Crawl.Common.DataAccess
{
    interface IDbConnetionProvider
    {
        Task<IDbConnection> GetConnectionAsync();

        Task Release(IDbConnection connection);
    }
}
