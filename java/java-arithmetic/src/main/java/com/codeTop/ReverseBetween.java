package com.codeTop;

import leetcode.helper.ListNode;

public class ReverseBetween {


    public static void main(String[] args) {

        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        ListNode listNode1 = new ReverseBetween().reverseBetween(listNode, 3, 6);
        System.out.println(listNode1.printListNode());
    }


    public ListNode reverseBetween2(ListNode head, int left, int right) {

        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode pre = head;
        for (int i =0;i<left-1;i++){
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for (int i =0;i<right-left+1;i++){
            rightNode = rightNode.next;
        }
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        reverse(leftNode);

        pre.next = leftNode;
        leftNode.next = curr;

        return dump.next;
    }




















    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;
        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverse(leftNode);

        pre.next = rightNode;
        leftNode.next = curr;

        return dummyNode.next;
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
