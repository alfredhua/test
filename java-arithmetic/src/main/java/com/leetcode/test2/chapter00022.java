package com.leetcode.test2;

/**
 * @author guozhenhua
 * @date 2020/03/31
 */
public class chapter00022 {


    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {

        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        firstNode.next  = swapPairs2(secondNode.next);
        secondNode.next = firstNode;
        return secondNode;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;
        while ((head != null) && (head.next != null)) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            prevNode = firstNode;
            head = firstNode.next; // jump
        }

        return dummy.next;
    }



}
