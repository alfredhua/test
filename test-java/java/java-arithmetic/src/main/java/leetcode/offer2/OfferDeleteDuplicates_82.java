package leetcode.offer2;

import leetcode.helper.ListNode;

public class OfferDeleteDuplicates_82 {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode currentNode =dummy;
        while (currentNode.next!=null && currentNode.next.next!=null){
            if (currentNode.next.val == currentNode.next.next.val){
                int x = currentNode.next.val;
                while (currentNode.next!=null && currentNode.next.val == x){
                    currentNode.next = currentNode.next.next;
                }
            }else {
                currentNode = currentNode.next;
            }
        }
        return dummy.next;
    }

}
