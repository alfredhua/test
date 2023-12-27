package leetcode.review.listnode;

import leetcode.helper.ListNode;

public class DeleteDuplicates {

    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode cur = dump;
        while (cur.next!=null && cur.next.next!=null){
            if (cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while ( x == cur.next.next.val){
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }

        }
        return dump.next;
    }
}
