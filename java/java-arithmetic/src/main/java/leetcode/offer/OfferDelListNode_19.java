package leetcode.offer;

import leetcode.helper.ListNode;

public class OfferDelListNode_19 {

    public static void main(String[] args) {

//        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5, 6, 7});
//        System.out.println(new OfferDelListNode_19().removeNthFromEnd(listNode,2).printListNode());
//

        ListNode listNode2 = ListNode.createListNode(new int[]{1,2});
        System.out.println(new OfferDelListNode_19().removeNthFromEnd(listNode2,1).printListNode());
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node=head;
        int total=0;
        while (node!=null){
            node=node.next;
            total++;
        }
        ListNode ans=new ListNode(0,head);
        ListNode cur=ans;
        for (int i = 1; i < total - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return ans.next;
    }

}
