package leetcode.offer;

import leetcode.helper.ListNode;

public class OfferMergeTwoLists_21 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 4});
        ListNode listNode2 = ListNode.createListNode(new int[]{1, 3, 4});
        System.out.println(new OfferMergeTwoLists_21().mergeTwoLists(listNode,listNode2).printListNode());

    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }
        if (list1.val<list2.val){
             list1.next=mergeTwoLists2(list1,list2.next);
            return list1;
        }else {
            list2.next= mergeTwoLists2(list1.next,list2);
            return list2;
        }
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode result=new ListNode(0);
        ListNode prev = result;
        while (list1!=null || list2!=null){
            if (list1==null){
                prev.next=list2;
                break;
            }
            if (list2==null){
                prev.next=list1;
                break;
            }
            if (list1.val>=list2.val){
                prev.next=list2;
                list2=list2.next;
            }else{
                prev.next=list1;
                list1=list1.next;
            }
            prev=prev.next;
        }
        return result.next;
    }

}
