using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace Jasmine.DataStore.Service
{
    interface IDataDecoder
    {
       List<string> Decode(Stream s);
    }
}
