package leetcode.review.listnode;

import leetcode.helper.LinkNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最常被使用的放在前面
 *
 */
public class LRU {

    private Integer capacity;
    private LinkNode startNode;
    private LinkNode endNode;
    private Map<Integer,LinkNode> map = new HashMap<>();

    public LRU(Integer capacity) {
        this.capacity = capacity;
        this.startNode = new LinkNode();
        this.endNode = new LinkNode();
        startNode.next = endNode;
        endNode.pre = startNode;
    }

    public void put(Integer value){
        // 判断是否存在，存在，则 移动到头部 , 不存在则添加(是否超过容量，超过容量，删除队尾数据)
        LinkNode linkNode = map.get(value);
        if (linkNode==null){

        }else {
            linkNode.value = value;
            moveToHead(linkNode);
        }

    }

    public Integer get(Integer value){
        // 1. 判断列表是否存在数据，存在则挪到 列表头，不存在，返回 -1
        if (!map.containsKey(value)){
            return -1;
        }
        // 挪到列表头部，先删除，再添加
        LinkNode linkNode = map.get(value);
        moveToHead(linkNode);
        return linkNode.getValue();
    }

    private void removeNode(LinkNode node){

    }


    private void moveToHead(LinkNode node){

    }

}
