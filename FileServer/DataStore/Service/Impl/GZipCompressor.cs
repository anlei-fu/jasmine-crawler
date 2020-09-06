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
            using (var stream = new MemoryStream())
            {
                using (GZipStream s = new GZipStream(stream, CompressionLevel.Fastest))
                {
                    s.Write(source, 0, source.Length);
                    return stream.ToArray();
                }
            }
        }

        public byte[] DeCompress(byte[] source)
        {
            using (var stream = new MemoryStream())
            {
                using (GZipStream s = new GZipStream(stream, CompressionMode.Decompress))
                {
                    s.Write(source, 0, source.Length);
                    return stream.ToArray();
                }
            }
        }
    }
}
