using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.DataStore.Service
{
   public interface IDataEncoder
    {
        byte[] Encode(byte[] data);
    }
}
