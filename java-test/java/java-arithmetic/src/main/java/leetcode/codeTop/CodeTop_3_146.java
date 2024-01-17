package leetcode.codeTop;

import leetcode.helper.LinkNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 *
 */
public class CodeTop_3_146 {

    private int size;

    private Map<Integer,LinkNode> map;

    private LinkNode head;
    private LinkNode tail;

    public CodeTop_3_146(int capacity) {
        this.size=capacity;
        this.map = new HashMap<>();
        head = new LinkNode();
        tail = new LinkNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        LinkNode nodeValue=map.get(key);
        //不存在则
        if (nodeValue==null){
            return -1;
        }
        //刷新当前key的位置
        refreshNodeToHead(nodeValue);
        return nodeValue.value;
    }

    private void refreshNodeToHead(LinkNode node){
        removeNode(node);
        addNodeToHead(node);
    }

    /**
     * 删除节点
     * @param node
     */
    private void removeNode(LinkNode node){
        if (tail == node){
            tail = tail.pre;
            tail.next = null;
        }else if(head == node){
            head = head.next;
            head.pre = null;
        }else{
            node.pre.next= node.next;
            node.next.pre= node.pre;
        }
    }

    private void addNodeToHead(LinkNode node){
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        node.next = node;
    }

    public void put(int key, int value) {
        LinkNode node = map.get(key);
        //val不存在的话，则存放值，并且将该值放在头节点，
        // 如果长度> size 则需要删除尾节点
        if (null ==  node){
            if (map.size()>=size){
                removeNode(tail);
                map.remove(key);
            }else{
                node = new LinkNode(value);
                map.put(key,node);
                addNodeToHead(node);
            }
        }else {
            //如果存在，则将该节点值覆盖，并且从链表中删除，
            // 把它放在头节点上。
            node.value = value;
            map.put(key,node);
            refreshNodeToHead(node);
        }
    }

}
