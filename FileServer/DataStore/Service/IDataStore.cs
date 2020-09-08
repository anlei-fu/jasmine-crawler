using Jasmine.Crawler.Common.Model.Request;

namespace Jasmine.DataStore.Service
{
    interface IDataStore
    {
        bool Save(SaveDataRequest saveDataRequest);
    }
}
