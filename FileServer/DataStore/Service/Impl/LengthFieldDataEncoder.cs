using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.DataStore.Service.Impl
{
    public class LengthFieldDataEncoder : IDataEncoder
    {
        private ICompressor _compressor;
        public byte[] Encode(string data)
        {
            var content = Encoding.UTF8.GetBytes(data);
            var compressed = _compressor.Compress(content);
            var lengthField = BitConverter.GetBytes(compressed.Length);
            var output = new byte[compressed.Length + 4];
            Buffer.BlockCopy(lengthField, 0, output, 0, 4);
            Buffer.BlockCopy(compressed, 0, output, 4, compressed.Length);

            return output;
        }
    }
}
