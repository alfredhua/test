package com.codeTop;

import leetcode.helper.ListNode;

public class ReverseKGroup {


    public static void main(String[] args) {
        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        ListNode listNode1 = new ReverseKGroup().reverseKGroup(listNode, 3);
        System.out.println(listNode1.printListNode());
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode pre = dump;
        ListNode endNode = dump;
        while (endNode.next !=null){
            for (int i =0;i<k & endNode!=null;i++){
                endNode = endNode.next;
            }
            if (endNode==null){
                break;
            }
            // 第一步 将endNode断开
            ListNode startNode = pre.next;
            ListNode nextNode = endNode.next;
            endNode.next = null;
            // 反转;
            pre.next = reverse(startNode);
            //重新链接
            startNode.next = nextNode;
            pre = startNode;

            endNode = pre;
        }
        return dump.next;
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode current = head;
        while (current!=null){
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }

}
