package leetcode.codeTop;

import leetcode.helper.ListNode;

public class CodeTop_9_21 {

    public static void main(String[] args) {
        ListNode listNode1 = ListNode.createListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        ListNode listNode2 = ListNode.createListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        ListNode listNode = new CodeTop_9_21().mergeTwoLists(listNode1, listNode2);
        System.out.println(listNode.printListNode());
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode(0);
        ListNode result = listNode;
        while (list1!=null && list2!=null){
            if (list1.val>list2.val){
                listNode.next = list2;
                list2 = list2.next;
            }else {
                listNode.next = list1;
                list1=list1.next;
            }
            listNode=listNode.next;
        }
        if (list1==null){
            listNode.next=list2;
        }
        if (list2==null){
            listNode.next=list1;
        }
        return result.next;
    }
}
