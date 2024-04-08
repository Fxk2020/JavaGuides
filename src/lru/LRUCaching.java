package lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCaching extends LinkedHashMap<Integer, Integer> {
    private int cap;

    public LRUCaching(int cap){
        this.cap = cap;
    }

    public synchronized int get(int key){
        return super.get(key);
    }

    public synchronized void put(int key, int value){
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.size()>this.cap;
    }
}
