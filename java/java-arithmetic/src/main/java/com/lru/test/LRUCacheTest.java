package com.lru.test;

import leetcode.helper.LinkNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 长期不使用的数据，在未来被用到的几率也不大。因此当数据所占内存达到一个阈值是，可以选择移除掉最近最少被使用的数据来保持内存的高效使用，
 * 这是基于时间局部性原理的一个假设。LRU算法主要用于缓存算法，在节省资源的情况下提高数据访问效率。
 */
public class LRUCacheTest {


    public static void main(String[] args) {
        LRUCacheTest lruCache = new LRUCacheTest(3);
        lruCache.put("001",1);
        lruCache.put("002",2);
        lruCache.put("003",3);
        lruCache.put("004",4);
        lruCache.put("005",5);
        lruCache.get("002");
        lruCache.put("004",2);
        lruCache.put("006",6);
        System.out.println(lruCache.get("001"));
        System.out.println(lruCache.get("006"));
    }

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
        head = new LinkNode(0);
        end = new LinkNode(0);
        head.next = end;
        end.pre = head;
    }

    /**
     * put node
     * @param key
     * @param value
     */
    public void put(String key,Integer value) {
        LinkNode linkNode = hashMap.get(key);
        if (linkNode!=null){
            //如果超过了格式现在
            if (hashMap.size()>limit){
                //删除调最后的节点
                hashMap.remove(key);
                removeNode(end.pre);
            }else{
                //刷新当前节点
                refreshNode(linkNode);
            }
        }else{
            //没有节点，则直接添加
            LinkNode node = new LinkNode(value);
            addNode(node);
            hashMap.put(key,node);
        }
    }

    public LinkNode get(String key){
        LinkNode linkNode = hashMap.get(key);
        if (linkNode==null){
            return null;
        }else {
            //刷新节点
            refreshNode(linkNode);
            return linkNode;
        }
    }

    /**
     * remove node
     * @param key
     */
    public void remove(String key){
        LinkNode node=hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }

    private void refreshNode(LinkNode node){
        removeNode(node);
        addNode(node);
    }

    /**
     * 头部插入节点数据  head  <-----> next
     * -------------         node
     * @param node
     */
    private void addNode(LinkNode node){
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    /**
     * 删除节点
     * @param node
     * @return
     */
    public void removeNode(LinkNode node){
        node.pre.next= node.next;
        node.next.pre = node.pre;
        node.pre =null;
        node.next = null;
    }

}
