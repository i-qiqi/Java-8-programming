package javaBasic;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU<K,V> {
    private LinkedHashMap<K,V> cache;
    private int cache_size;

    public LRU(int size){
        this.cache_size = size;
        cache = new LinkedHashMap<K, V>(16, 0.75f, true){
            protected  boolean removeEldestEntry(Map.Entry eldest){
                if(cache_size + 1 == cache.size()){
                    return true;
                }else{
                    return false;
                }
            }
        };
    }
    public synchronized V get(K key){
        return cache.get(key);
    }

    public synchronized void put(K key , V value){
        cache.put(key, value);
    }

    public synchronized void clear(){
        cache.clear();
    }

    public synchronized int usedSize(){
        return cache.size();
    }
    public void print(){
        for(Map.Entry<K,V> entry : cache.entrySet()){
            System.out.println(entry.getValue()+"--");
        }
        System.out.println();
    }

    public static void main(String[] args){
        LRU<String, Integer> LRUCache = new LRU<>(3);
        LRUCache.put("key1" , 1);
        LRUCache.put("key2" , 2);
        LRUCache.put("key3" , 3);
        LRUCache.print();
        System.out.println();
        LRUCache.put("key4" , 4);
        LRUCache.print();
        System.out.println();
        LRUCache.put("key5" , 5);
        LRUCache.print();
    }
}
