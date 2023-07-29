package com.codeTop;

import leetcode.helper.ListNode;

public class ReverseList {

    public static void main(String[] args) {
        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        ListNode listNode1 = new ReverseList().reverseList(listNode);
        System.out.println(listNode1.printListNode());
    }

    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode newHead=reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode currentNode = head;
        while (currentNode!=null){
            ListNode temp = currentNode.next;
            currentNode.next = pre;
            pre = currentNode;
            currentNode = temp;

        }
        return pre;
    }

}
