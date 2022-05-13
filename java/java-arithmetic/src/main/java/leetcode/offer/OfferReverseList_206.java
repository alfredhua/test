package leetcode.offer;

import leetcode.editor.helper.ListNode;

public class OfferReverseList_206 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
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
