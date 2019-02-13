﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;

namespace ConsoleApp1.Model.ADT
{
    public interface IOutput<V> : IEnumerable
    {
        void AddValue(V el);
    }
}
