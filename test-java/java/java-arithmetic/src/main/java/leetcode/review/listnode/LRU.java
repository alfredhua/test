package leetcode.review.listnode;

import leetcode.helper.LinkNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最常被使用的放在前面
 */
public class LRU {

    private Integer capacity;
    // head ---- a ---  b ----- tail
    private LinkNode head;
    private LinkNode tail;
    private Map<Integer, LinkNode> map = new HashMap<>();
    private int size =0;

    public LRU(Integer capacity) {
        this.capacity = capacity;
        this.head = new LinkNode();
        this.tail = new LinkNode();
        head.next = tail;
        tail.pre = head;
    }

    public void put(Integer value) {
        LinkNode linkNode = map.get(value);
        if (linkNode == null) {
//            不存在则添加(是否超过容量，超过容量，删除队尾数据)
            linkNode = new LinkNode(value);
            map.put(value,linkNode);
            addNodeHead(linkNode);
            ++size;
            if (size>capacity){
                //删除最后的节点
                LinkNode tail = removeTail();
                map.remove(tail.value);
                --size;
            }
        } else {
//            存在，则 移动到头部
            linkNode.value = value;
            moveToHead(linkNode);
        }

    }

    private LinkNode removeTail() {
        LinkNode res = tail.getPre();
        removeNode(res);
        return res;
    }

    public Integer get(Integer value) {
        // 1. 判断列表是否存在数据，存在则挪到 列表头，不存在，返回 -1
        if (!map.containsKey(value)) {
            return -1;
        }
        // 挪到列表头部，先删除，再添加
        LinkNode linkNode = map.get(value);
        moveToHead(linkNode);
        return linkNode.getValue();
    }

    private void removeNode(LinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addNodeHead(LinkNode node) {
        LinkNode t = head.next;
        head.next = node;
        node.next = t;
        t.pre = node;
        node.pre = head;
    }
    private void moveToHead(LinkNode node) {
        removeNode(node);
        addNodeHead(node);
    }


}
