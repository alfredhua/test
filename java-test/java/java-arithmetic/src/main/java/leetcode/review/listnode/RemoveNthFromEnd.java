package leetcode.review.listnode;

import leetcode.helper.ListNode;

public class RemoveNthFromEnd {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1,head);
        ListNode firstNode =  head;
        for (int i=0;i<n;i++){
            firstNode = firstNode.next;
        }
        ListNode secondNode = dummy;
          while (firstNode != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        secondNode.next = secondNode.next.next;
         ListNode ans = dummy.next;
        return ans;
    }
}
