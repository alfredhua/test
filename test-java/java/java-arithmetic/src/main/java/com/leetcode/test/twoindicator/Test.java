package com.leetcode.test.twoindicator;

/**
 * Created by guozhenhua
 * date 2020/5/25.
 * 列表循环
 */
public class Test {

    class ListNode {

        ListNode next;

        private int num;

        public ListNode(int num) {
            this.num = num;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }


    private  static boolean hasCycle(ListNode head){
        ListNode fast=head,slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
