using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.DataStore.Service.Impl
{
    public class LengthFieldDataEncoder : IDataEncoder
    {
        public byte[] Encode(byte[] data)
        {
            var lengthField = BitConverter.GetBytes(data.Length);
            var output = new byte[data.Length + 4];
            Buffer.BlockCopy(lengthField, 0, output, 0, 4);
            Buffer.BlockCopy(data, 0, output, 4, data.Length);

            return output;
        }
    }
}
