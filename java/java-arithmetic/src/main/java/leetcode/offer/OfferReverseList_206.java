package leetcode.offer;

import leetcode.editor.helper.ListNode;

public class OfferReverseList_206 {
    public static void main(String[] args) {

    }


    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode newHead=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode pre=null;
        ListNode current=head;
        while (current!=null){
            ListNode temp=current.next;
            current.next=pre;
            pre=current;
            current=temp;
        }
        return pre;
    }

}
