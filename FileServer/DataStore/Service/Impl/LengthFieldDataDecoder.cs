﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.IO;
using System.Text;

namespace Jasmine.DataStore.Service.Impl
{
    public class LengthFieldDataDecoder : IDataDecoder
    {
        private ICompressor _compressor;

        public List<string> Decode(Stream s)
        {
            var ls = new List<string>();
            var bt = new byte[4];
            var readed = -1;
            while (true)
            {
                readed = s.Read(bt, 0, 4);
                if (readed == -1)
                    break;

                var length = BitConverter.ToInt32(bt, 0);
                var content = new byte[length];
                s.Read(content, 0, length);
                ls.Add(Encoding.UTF8.GetString(_compressor.DeCompress(content)));
            }

            return ls;
        }
    }
}
