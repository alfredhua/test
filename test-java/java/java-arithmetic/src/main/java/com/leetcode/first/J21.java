package com.leetcode.first;

public class J21 {

    public static void main(String[] args) {
        ListNode l1=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        ListNode l2=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        ListNode listNode = new J21().mergeTwoLists(l1, l2);
        System.out.println(listNode);

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode pre=head;
        while(l1!=null && l2!=null){
            if (l1.val<=l2.val){
                pre.next=l1;
                l1=l1.next;
            }else{
                pre.next=l2;
                l2=l2.next;
            }
            pre =pre.next;
        }
        pre.next=(l1==null?l2:l1);
        return head.next;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}