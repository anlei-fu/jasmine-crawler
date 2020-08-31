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


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MatchingRecharge.Utility
{
    public class NamingUtils
    {
        /// <summary>
        ///upper_first_letter -> UpperFirstLetter
        /// </summary>
        /// <param name="hungary"></param>
        /// <returns></returns>
        public static string HunaryToPascal(string hungary)
        {
            hungary = hungary.ToLower();
            var pascal = "";
            hungary.Split(',').ToList().ForEach(w =>
            {
                if (w == "_")
                    return;
                pascal += UpperFirstLetter(w);
            });

            return pascal;
        }

        /// <summary>
        /// UpperFirstLetter -> upper_first_letter
        /// </summary>
        /// <param name="pascal"></param>
        /// <returns></returns>
        public static string PascalToHungary(string pascal)
        {

            var output = "";
            bool isFirstLetter = true;
            var word = "";
            foreach (var c in pascal)
            {
                if (c >= 'A' && c <= 'Z')
                {
                    if (!isFirstLetter)
                    {
                        output += "_" + word.ToUpper();
                        word = "" + c;
                    }
                    else
                    {
                        word += c;
                        isFirstLetter = false;
                    }
                }
                else
                {
                    word += c;
                }
            }

            if (word.Length > 0)
                output += "_" + word.ToUpper();

            if (output.StartsWith("_"))
                output = output.Substring(1, word.Length - 1);

            return output;
        }

        public static string UpperFirstLetter(string source)
        {
            if (source.Length == 1)
                return source.ToUpper();

            return source.Substring(0, 1).ToUpper() + source.Substring(1, source.Length - 1);

        }
    }
}
