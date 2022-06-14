package com.leetcode.codeTop;

import leetcode.editor.helper.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author guozhenhua
 * @date 2022/6/14
 */
public class CodeTop_1_206 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(new CodeTop_1_206().reverseList(listNode).printListNode());
    }


    // head ----> head.next --->   head.next.next
    // currentNode ----> currentNode.next --->   currentNode.next.next
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode temp;
        while (head!=null){
            temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }


    // 用额外内存
    public ListNode reverseList3(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        while (head!=null){
            ListNode temp = head.next;
            head.next = null;
            deque.add(head);
            head = temp;
        }
        ListNode listNode=new ListNode(0);
        ListNode pre = listNode;
        while (!deque.isEmpty()){
            listNode.next= deque.pollLast();
            listNode=listNode.next;
        }
        return pre.next;
    }


    // head ----> head.next --->   head.next.next
    public ListNode reverseList2(ListNode head) {
        if (head==null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head.next;
        head.next = null;
        return newHead;
    }
}
