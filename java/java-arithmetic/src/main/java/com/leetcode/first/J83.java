package com.leetcode.first;

public class J83 {

    public static void main(String[] args) {
//        ListNode listNode = new ListNode(2, null);
        ListNode listNode = new J83().deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, null))));
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }

    }

    public ListNode deleteDuplicates(ListNode head) {
       if (head==null){
           return head;
       }
       ListNode currentNode=head;
       while (currentNode.next!=null){
           if (currentNode.val==currentNode.next.val){
               currentNode.next=currentNode.next.next;
           }else{
               currentNode=currentNode.next;
           }
       }
       return head;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
