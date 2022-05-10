package leetcode.codetop;

import java.util.LinkedHashMap;
import java.util.Map;

public class Top_02 {

    public static void main(String[] args) {

    }



}

class LRUCache extends LinkedHashMap<Integer,Integer>{

    private int capacity;

    public LRUCache(int initialCapacity) {
        super(initialCapacity, 0.75F, true);
        this.capacity=initialCapacity;
    }

    @Override
    public Integer get(Object key) {
        return super.get(key);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>capacity;
    }

    @Override
    public Integer put(Integer key, Integer value) {
        return super.put(key, value);
    }
}