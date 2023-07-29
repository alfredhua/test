package com.codeTop;

import leetcode.helper.LinkNode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

    private Integer capacity;
    private LinkNode head;
    private LinkNode tail;
    private int size;
    private Map<Integer,LinkNode> map = new HashMap<>();

    public LRUCache2(Integer capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new LinkNode();
        this.tail = new LinkNode();
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public void put(Integer key,Integer value){
        LinkNode linkNode = map.get(key);
        if (linkNode == null){
            LinkNode newNode = new LinkNode(value);
            map.put(key,newNode);
            addNode(newNode);
            ++size;
            if (size>capacity){
                LinkNode tail = removeTail();
                map.remove(tail.getValue());
                --size;
            }
        }else {
            linkNode.value = value;
            moveToHead(linkNode);
        }
    }

    public Integer get(Integer key){
        LinkNode value = map.get(key);
        if (value==null){
            return -1;
        }
        //不为空，则 移动到头部
        moveToHead(value);
        return value.getValue();
    }

    private void addNode(LinkNode node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(LinkNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private LinkNode removeTail(){
        LinkNode res = tail.getPre();
        removeNode(res);
        return res;
    }
    //最好的办法就是，先删除，后增加
    private void moveToHead(LinkNode node){
        addNode(node);
        removeNode(node);
    }




}
