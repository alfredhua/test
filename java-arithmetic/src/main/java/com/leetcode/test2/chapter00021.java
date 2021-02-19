package com.leetcode.test2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author guozhenhua
 * @date 2020/03/30
 */
public class chapter00021 {


    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

  }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue((Comparator<ListNode>) (o1, o2) -> (o1.val - o2.val));
        for(int i=0;i<lists.length;i++) {
            while(lists[i] != null) {
                queue.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while( !queue.isEmpty() ) {
            dummy.next = queue.poll();
            dummy = dummy.next;
        }
        dummy.next = null;
        return head.next;
    }

}
