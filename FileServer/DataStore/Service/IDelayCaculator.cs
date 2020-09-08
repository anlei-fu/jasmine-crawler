using System;
using System.Collections.Generic;
using System.Text;

namespace Jasmine.DataStore.Service
{
   public interface IDelayCaculator
    {
        int NextDelay(bool positive = true);
    }
}
