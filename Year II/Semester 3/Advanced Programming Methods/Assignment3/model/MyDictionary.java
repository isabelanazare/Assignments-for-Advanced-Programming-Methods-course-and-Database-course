package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import Exception.*;
public class MyDictionary <K, V> implements MyIDictionary<K, V>  {
    private HashMap<K, V> _map;

    public MyDictionary(HashMap<K, V> _map) {
        this._map = _map;
    }

    @Override
    public V put(K key, V value) {
        return this._map.put(key, value);
    }

    @Override
    public boolean exists(K key) {
        return _map.containsKey(key);
    }
    @Override
    public V get(K key) {

        if(!exists(key))
            throw new VariableNotDefined("Variable not defined in dictionary");

        return this._map.get(key);
    }

    @Override
    public Collection<V> values() {
        return this._map.values();
    }

    @Override
    public Collection<K> keys() {
        return this._map.keySet();
    }

    @Override
    public V remove(K fd) {
        return this._map.remove(fd);
    }

    @Override
    public MyIDictionary<K, V> clone() {
        MyIDictionary<K, V> dict = new MyDictionary<>(new HashMap<K, V>());
        for(K key : _map.keySet())
            dict.put(key, _map.get(key));
        return dict;
    }

    @Override
    public Map<K, V> toMap() {
        return this._map;
    }

    @Override
    public String toString() {
        String ret = "";
        boolean ok = false;
        for(HashMap.Entry<K, V> entry : this._map.entrySet()) {
            if(ok)
                ret = ret + "\n";
            ret += entry.getKey().toString() + " -> " + entry.getValue().toString()+"\r\n";
            ok = true;
        }
        return ret;
    }
}