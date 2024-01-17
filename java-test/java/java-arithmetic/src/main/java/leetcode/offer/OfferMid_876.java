package leetcode.offer;

import leetcode.helper.ListNode;

public class OfferMid_876 {

    public static void main(String[] args) {
        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(new OfferMid_876().middleNode(listNode).val);

        ListNode listNode1 = ListNode.createListNode(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(new OfferMid_876().middleNode(listNode1).val);
    }

    public ListNode middleNode(ListNode head) {
        int left =0;
        int right =0;
        ListNode first=head;
        while (first!=null){
            first= first.next;
            right++;
        }
        while (head!=null){
            if (left == right / 2 ){
                return head;
            }
            head =head.next;
            left++;
        }
        return null;
    }


}
