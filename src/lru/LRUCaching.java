package lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCaching extends LinkedHashMap<Integer, Integer> {
    private final int cap;

    public LRUCaching(int cap){
        super(cap, 0.75f, true);
        this.cap = cap;
    }

    public synchronized int get(int key){
        return getOrDefault(key, -1);
    }

    public synchronized void put(int key, int value){
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.size()>this.cap;
    }
}
