package leetcode.review.listnode;

import leetcode.helper.ListNode;

public class Partition {


    public static void main(String[] args) {

        System.out.println(new Partition().partition(ListNode.createListNode(new int[]{1,4,3,2,5,2}),3).printListNode());

    }


    public ListNode partition(ListNode head, int x) {
        ListNode startNode = new ListNode(-1);
        ListNode a = startNode;
        ListNode rightNode = new ListNode(-1);
        ListNode b = rightNode;
        while (head!=null){
            if (head.val < x){
                startNode.next = head;
                startNode = startNode.next;
            }else {
                rightNode.next = head;
                rightNode = rightNode.next;
            }
            head = head.next;
        }
        rightNode.next = null;
        startNode.next =  b.next;
        return a.next;
    }
}
