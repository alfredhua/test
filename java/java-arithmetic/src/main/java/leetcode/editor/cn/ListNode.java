package leetcode.editor.cn;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ListNode {
      Integer val;
      ListNode next;

    public ListNode() {
    }

    public ListNode(Integer val) {
        this.val = val;
    }

    public ListNode(Integer val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public static ListNode createListNode(int[] nodes){
        ListNode head = new ListNode(-1);
        ListNode node = head;
        for (int i=0;i<nodes.length;i++){
            ListNode node1 = new ListNode(nodes[i]);
            node.setNext(node1);
            node=node1;
        }
        return head.next;
    }


    public List<Integer> printListNode(){
        ListNode listNode=this;
        List<Integer> list=new ArrayList<>();
        while (listNode!=null){
            list.add(listNode.val);
            listNode=listNode.next;
        }
        return list;
    }

}