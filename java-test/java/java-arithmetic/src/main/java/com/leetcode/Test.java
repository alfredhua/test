package com.leetcode;

import leetcode.helper.ListNode;

public class Test {

    public static void main(String[] args) {

    }

    public ListNode reverseNumber(ListNode head,int m , int n){
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode currentNode = pre;
        for (int i = 1 ; i<m;i++){
            currentNode = currentNode.next;
        }
        currentNode = currentNode.next;
        ListNode preNode = null;
        for (int i=m;i<n;i++){
            ListNode temp = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = temp;
        }
        return pre.next;
    }

    /**
     * 反转列表
     * @param listNode
     * @return
     */
    public ListNode reverse(ListNode listNode) {
        ListNode pre=null;
        ListNode currentNode = listNode;
        while(currentNode!=null){
            ListNode temp = currentNode.next;
            currentNode.next = pre;
            pre = currentNode;
            currentNode = temp;
        }
        return pre;
    }
}
