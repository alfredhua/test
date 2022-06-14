package com.leetcode.codeTop;

import leetcode.editor.helper.ListNode;

/**
 * @author guozhenhua
 * @date 2022/6/14
 */
public class CodeTop_1_206 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(new CodeTop_1_206().reverseList(listNode).printListNode());
    }
    public ListNode reverseList(ListNode head) {
        ListNode currentNode =head;
        ListNode result = new ListNode(0);
        while (currentNode!=null && currentNode.next!=null){
            ListNode temp = currentNode.next.next;
            currentNode.next.next = currentNode.next;
            currentNode = temp;
            result.next = temp;
        }
        return result.next;
    }
}
