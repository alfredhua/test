package com.lru.test;

import leetcode.helper.LinkNode;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheTest {

    private LinkNode head;

    private LinkNode end;

    /**
     * 缓存上限
     */
    private int limit;

    private Map<String,LinkNode> hashMap;

    public LRUCacheTest(int limit) {
        this.limit = limit;
        hashMap = new HashMap<>();
    }

    /**
     * put node
     * @param key
     * @param value
     */
    public void put(String key,String value) {

    }

    /**
     * remove node
     * @param key
     */
    public void remove(String key){
    }

//    private void addNode(LinkNode node){
//
//    }
//
//    public String removeNode(LinkNode node){
//        return "";
//    }

}
