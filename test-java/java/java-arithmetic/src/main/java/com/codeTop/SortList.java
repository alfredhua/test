package com.codeTop;

import leetcode.helper.ListNode;

public class SortList {

    public static void main(String[] args) {
        ListNode listNode = ListNode.createListNode(new int[]{4, 3, 1, 2, 8, 10, -4});
        ListNode listNode1 = new SortList().insertionSortList(listNode);
        System.out.println(listNode1.printListNode());

    }


    public ListNode insertionSortList(ListNode listNode){
        ListNode dump = new ListNode(0);
        dump.next = listNode;
        ListNode currentNode = listNode.next;
        ListNode lastSortNode = listNode; //排序后的最后一个节点
        while (currentNode!=null){
            //最后一个节点比 当前节点小 那么直接往后排序即可
            if (lastSortNode.val<=currentNode.val){
                lastSortNode = lastSortNode.next;
            }else {
                // 需找要插入的位置
                ListNode prev = dump;
                while (prev.next.val <= currentNode.val) {
                    prev = prev.next;
                }
                // pre 就是要插入的位置
                lastSortNode.next = currentNode.next;
                currentNode.next = prev.next;
                prev.next = currentNode;
            }
            currentNode = lastSortNode.next;
        }
        return dump.next;
    }


}
