using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.DataStore.Service
{
  public  interface ICompressor
    {
        byte[] Compress(byte[] source);

        byte[] DeCompress(byte[] source);
    }
}
