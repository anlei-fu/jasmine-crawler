using Jasmine.DataStore.Service;
using System;

namespace DataStore
{
    public class Program
    {
        public static void Main(string[] args)
        {
            new DataSaveJob("config.json").Run();
        }
    }
}
