package leetcode.review.listnode;

import leetcode.helper.ListNode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode listNode = new AddTwoNumbers().addTwoNumbers(ListNode.createListNode(new int[]{ 2,4, 3}), ListNode.createListNode(new int[]{5,6,4}));
        System.out.println(listNode.printListNode());

        ListNode listNode2 = new AddTwoNumbers().addTwoNumbers(ListNode.createListNode(new int[]{ 9,9,9,9,9,9,9}), ListNode.createListNode(new int[]{9,9,9,9}));
        System.out.println(listNode2.printListNode());
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode result = new ListNode();
        ListNode t = result;
        int temp = 0;
        while (head1 != null || head2 != null) {
            int a1 = 0, a2 = 0;
            if (head1 == null) {
                a1 = 0;
            } else {
                a1 = head1.getVal();
                head1 = head1.next;
            }
            if (head2 == null) {
                a2 = 0;
            }else {
                a2 = head2.getVal();
                head2 = head2.next;
            }
            int x =a1+a2+temp;
            if (x >9 ){
                temp = 1;
                result.next = new ListNode(x % 10);
            }else {
                result.next = new ListNode(x);
                temp =0;
            }
            result = result.next;
        }
        if (temp>0){
            result.next = new ListNode(temp);
        }
        return t.next;
    }
}
