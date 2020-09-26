using System;
using System.Collections.Generic;
using System.IO;
using System.IO.Compression;
using System.Text;

namespace Jasmine.DataStore.Service.Impl
{
    public class GZipCompressor : ICompressor
    {
        public byte[] Compress(string data)
        {
            return Compress(Encoding.UTF8.GetBytes(data));
        }
        public byte[] Compress(byte[] source)
        {
            using (var outStream = new MemoryStream())
            {
                using (var tinyStream = new GZipStream(outStream, CompressionMode.Compress))
                using (var mStream = new MemoryStream(source))
                    mStream.CopyTo(tinyStream);

                return outStream.ToArray();
            }
        }

        public byte[] Decompress(byte[] source)
        {
            using (var inStream = new MemoryStream(source))
            using (var bigStream = new GZipStream(inStream, CompressionMode.Decompress))
            using (var bigStreamOut = new MemoryStream())
            {
                bigStream.CopyTo(bigStreamOut);
               return bigStreamOut.ToArray();
            }
        }
    }
}
