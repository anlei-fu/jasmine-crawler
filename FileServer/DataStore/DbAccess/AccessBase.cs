using Dapper;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Text;
using System.Threading.Tasks;

namespace Jasmine.DataStore.DbAccess
{
    public class AccessBase
    {
        private string _connectionString;

        public AccessBase(string connectionString)
        {
            _connectionString = connectionString;
        }

        public async Task<int> ExecuteAsync(string sql)
        {
            try
            {
                using (var connection = GetConnection())
                {
                    connection.Open();
                    return await connection.ExecuteAsync(sql);
                }
            }
            catch (Exception ex)
            {
                throw ex;
            }
        }

        public async Task<T> QuerySingleAsync<T>(string sql)
        {
            try
            {
                using (var connection = GetConnection())
                {
                    connection.Open();
                    return await connection.QueryFirstAsync<T>(sql);
                }
            }
            catch (Exception ex)
            {
                throw ex;
            }
        }

        public async Task<IEnumerable<T>> QueryAsync<T>(string sql)
        {
            try
            {
                using (var connection = GetConnection())
                {
                    connection.Open();
                    return await connection.QueryAsync<T>(sql);
                }
            }
            catch (Exception ex)
            {
                throw ex;
            }
        }

        public async Task ExecuteTransaction(string sql)
        {
            IDbTransaction trans = null;
            try
            {
                using (var connection = GetConnection())
                {
                    connection.Open();
                    trans = connection.BeginTransaction();
                    await connection.ExecuteAsync(sql, null, trans);
                    trans.Commit();
                }
            }
            catch (Exception ex)
            {
                if (trans != null)
                    trans.Rollback();

                throw ex;
            }
        }

        private IDbConnection GetConnection()
        {
            return new MySqlConnection(_connectionString);
        }
    }
}
