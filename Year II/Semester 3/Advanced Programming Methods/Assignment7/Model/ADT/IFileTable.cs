﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;

namespace ConsoleApp1.Model.ADT
{
    public interface IFileTable<K, V> : IEnumerable
    {
        void AddValue(K key, V value);
        void UpdateValue(K key, V value);
        void Remove(K key);
        bool Contains(K key);
        V GetValue(K key);
    }
}
