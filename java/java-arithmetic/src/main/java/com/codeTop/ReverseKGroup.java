package com.codeTop;

import leetcode.helper.ListNode;

public class ReverseKGroup {


    public static void main(String[] args) {
        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        ListNode listNode1 = new ReverseKGroup().reverseKGroup(listNode, 3);
        System.out.println(listNode1.printListNode());
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode startNode = null;
        ListNode endNode = null;
        ListNode currentNode = head;
        int i = 0;
        while (currentNode !=null){
            if (i == k){
                endNode  =  currentNode;
                //这里反转
                endNode.next = null;
                
                i=0;
            }
            if (i == 1 ){
                startNode = currentNode;
            }
            currentNode = currentNode.next;
            i++;
        }
        return null;
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode current = head;
        while (current!=null){
            ListNode temp = head.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }

}
