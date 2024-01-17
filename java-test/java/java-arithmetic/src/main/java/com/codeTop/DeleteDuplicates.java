package com.codeTop;

import leetcode.helper.ListNode;

public class DeleteDuplicates {


    public static void main(String[] args) {
        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 6, 7, 8, 8, 8});
        ListNode listNode1 = new DeleteDuplicates().deleteDuplicates(listNode);
        System.out.println(listNode1.printListNode());
    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next!=null && cur.next.next!=null){
            if (cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

}
