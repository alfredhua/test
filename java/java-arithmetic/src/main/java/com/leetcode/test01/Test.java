package com.leetcode.test01;

import leetcode.helper.ListNode;

/**
 *  已知单链表 1->2->3->4->5，删除倒数第三个节点，倒置之后返回头结点 5 并打印 5 4 2 1，需自定义链表结构
 */
public class Test {

    public static void main(String[] args) {
        ListNode listNode = ListNode.createListNode(new int[]{1,2,3,4,5});
        ListNode reveNode = new Test().reve(listNode, 3);
        System.out.println(reveNode.printListNode());
    }


    /**
     * 1->2->3->4->5
     * @param listNode
     * @param k
     * @return
     */
    private ListNode reve(ListNode listNode, int k){
        ListNode start= listNode;
        ListNode end = listNode;
        //删除
        int i =0;
        //1.先找到要删除的节点。
        // 1.1 俩个节点，一个先走k下，然后 开始节点继续走，当end 为空的时候，则 start 就是那个要删除的节点。
        // 1,2,3,4,5
        while (end!=null){
            end = end.next;
            i++;
            if (i>k+1){
                start =start.next;
            }
        }
        start.next=start.next.next;
        ListNode reverce = reverce(listNode);
        return reverce;
    }

    /**
     * 反转列表
     * @param head
     * @return
     */
    public ListNode reverce(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        ListNode newHead = reverce(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

}
