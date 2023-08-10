package com.codeTop;

import leetcode.helper.ListNode;

public class DetectCycle {


    public static void main(String[] args) {

    }


    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null  && slow!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }
        fast  = head;
        while (fast!=slow){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
