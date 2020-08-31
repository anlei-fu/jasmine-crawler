using Dapper;
using Jasmine.Crawl.Common.DataAccess;
using System;
using System.Collections.Generic;
using System.Data;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace Jasmine.Crawl.Common
{
  public  class DataAccessBase<T>
    {
        private IDbConnetionProvider _dbConnetionProvider;

        private string _tableName;

        private string _pkField;

        private Type _pkType;

        public async  Task<bool> CreateAsync(T data)
        {
            return await ExecuteAsync(CreateInsertString(data))>0;
        }

        public Task<T> GetByIdAsync(string id)
        {

        }

        public Task<bool> UpdateAsync(IEnumerable<string> ids,T data)
        {

        }

        public Task UpdateBatchAsync()
        {

        }

        public Task<bool> DeleteAsync(string id)
        {

        }

        public Task<bool> DeleteBatchAsync(IEnumerable<string> ids)
        {

        }

        private Task<IDbConnection> GetConnection()
        {
            return _dbConnetionProvider.GetConnectionAsync();
        }

        private void Release(IDbConnection connection)
        {
            
        }

        private async Task<int> ExecuteAsync(string sql)
        {
            IDbConnection cnn=null;
            try
            {
                 cnn = await _dbConnetionProvider.GetConnectionAsync();
                var result = await cnn.ExecuteAsync(sql) ;
                return result;
            }
            finally
            {    if (cnn != null)
                   await _dbConnetionProvider.Release(cnn);
            }
            }
        private string CreateInsertString(T data)
        {
            return null;
        }
    }
}
