package com.generic.java;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Dictionary<Character, Integer> ascii = new Dictionary<Character, Integer>();
        ascii.set('A', 65);
        ascii.set('B', 66);
        System.out.println(ascii.get('A'));
    }
}

class Dictionary<K, V> {
    private ArrayList<K> keys = new ArrayList<K>();
    private ArrayList<V> values = new ArrayList<V>();

    public V get(K key) {
        int position = this.keys.indexOf(key);
        if (position == -1) {
            return null;
        }
        return this.values.get(position);
    }

    public void set(K key, V value) {
        int position = this.keys.indexOf(key);
        if (position == -1) {
            this.keys.add(key);
            this.values.add(value);
        } else {
            this.keys.set(position, key);
            this.values.set(position, value);
        }
    }

    public void remove(K key) {
        int position = this.keys.indexOf(key);
        if (position != -1) {
            this.keys.remove(position);
            this.values.remove(position);    
        }
    }

    public boolean has(K key){
        return this.keys.contains(key);
    }

    public void clear(){
        this.keys.clear();
        this.values.clear();
    }
}