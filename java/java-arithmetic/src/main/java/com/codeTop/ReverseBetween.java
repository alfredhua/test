package com.codeTop;

import leetcode.helper.ListNode;

public class ReverseBetween {


    public static void main(String[] args) {

        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        ListNode listNode1 = new ReverseBetween().reverseBetween(listNode, 3, 6);
        System.out.println(listNode1.printListNode());
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode currentNode = head;
        ListNode startNode = null;
        ListNode result = new ListNode(0);
        while (currentNode!=null){
            if (currentNode.val == left){
                startNode = currentNode;
                //开始反转
            }else{
            }
            ListNode temp = currentNode;
            result.next = temp;
            currentNode = currentNode.next;
        }
        return  null;
    }


    public ListNode reverse(ListNode node){
        ListNode currentNode = node;
        ListNode pre = null;
        while (currentNode!=null){
            ListNode temp = currentNode.next;
            currentNode.next = pre;
            pre = currentNode;
            currentNode = temp;
        }
        return pre;
    }

}
