package com.codeTop;

import leetcode.helper.ListNode;

import java.util.Stack;

public class ReorderList {

    public static void main(String[] args) {
        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
        new ReorderList().reorderList(listNode);
//        System.out.println(listNode.printListNode());;
        System.out.println(listNode);
    }


    public void reorderList(ListNode head) {
        Stack<ListNode> stack =new Stack<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            stack.add(currentNode);
            currentNode = currentNode.next;
        }

        ListNode pre = head;
        while (pre != null) {
            ListNode stackNode = stack.pop();
            if (stackNode.val.equals(pre.val)){
                break;
            }
            ListNode temp = pre.next;
            pre.next = stackNode;
            stackNode.next = temp;
            pre = temp;
        }
        pre.next = null;
        System.out.println("-----------");
    }
}
