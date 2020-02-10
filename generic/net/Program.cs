using System;
using System.Collections.Generic;

namespace net
{
    class Program
    {
        static void Main(string[] args)
        {
                Dictionary<char?, int?> ascii = new Dictionary<char?, int?>();
                ascii.Set('A', 78);
                ascii.Set('B', 66);
                Console.WriteLine(ascii.Get('A'));
                Console.WriteLine(ascii.Get('C') == null);
        }
    }

    class Dictionary<K, V> 
    {
        private List<K> _keys = new List<K>();
        private List<V> _values = new List<V>();

        public V Get(K key)
        {
            int position = this._keys.IndexOf(key);
            if (position == -1)
            {
                return default(V);
            }
            return this._values[position];
        }

        public void Set(K key, V value)
        {
            int position = this._keys.IndexOf(key);
            if (position == -1)
            {
                this._keys.Add(key);
                this._values.Add(value);
            }
            else
            {
                this._keys[position] = key;
                this._values[position] = value;
            }
        }

        public void Remove(K key)
        {
            int position = this._keys.IndexOf(key);
            if (position != -1)
            {
                this._keys.RemoveAt(position);
                this._values.RemoveAt(position);
            }
        }

        public bool Has(K key)
        {
            return this._keys.Contains(key);
        }

        public void Clear()
        {
            this._keys.Clear();
            this._values.Clear();
        }
    }
}
