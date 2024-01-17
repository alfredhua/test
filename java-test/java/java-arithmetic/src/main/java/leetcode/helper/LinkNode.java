package leetcode.helper;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guozhenhua7
 */
@Getter
@Setter
public class LinkNode {

    private String key;
    public int value;
    public LinkNode pre;
    public LinkNode next;

    public LinkNode() {}
    public LinkNode(String key,int value) {
        this.key = key;
        this.value = value;
    }
    public LinkNode(int value) {
        this.value = value;
    }

    public LinkNode(int value, LinkNode pre, LinkNode next) {
        this.value = value;
        this.pre = pre;
        this.next = next;
    }


    public List<Integer> printListNode(){
        LinkNode listNode=this;
        List<Integer> list=new ArrayList<>();
        while (listNode!=null){
            list.add(listNode.value);
            listNode=listNode.next;
        }
        return list;
    }

}