package leetcode.codeTop;

import leetcode.helper.ListNode;

public class CodeTop_23_23 {
    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[]{ListNode.createListNode(new int[]{1,2,3,4,5,6}),ListNode.createListNode(new int[]{2,3,4,5,6,7}),ListNode.createListNode(new int[]{5,6,7,8})};
        ListNode listNode = new CodeTop_23_23().mergeKLists(listNodes);
        System.out.println(listNode.printListNode());
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        for (int i =1;i<length;i++){
            lists[i] = merger2(lists[i-1],lists[i]);
        }
        return lists[length-1];
    }

    private ListNode merger2(ListNode listNode1,ListNode listNode2){
        ListNode listNode = new ListNode(0);
        ListNode temp = listNode;
        while (listNode1!=null && listNode2!=null){
            if (listNode1.val<listNode2.val){
                listNode.next = listNode1;
                listNode1 = listNode1.next;
            }else {
                listNode.next = listNode2;
                listNode2 = listNode2.next;
            }
            listNode=listNode.next;
        }
        if (listNode1==null){
            listNode.next=listNode2;
        }

        if (listNode2==null){
            listNode.next=listNode1;
        }
        return temp.next;
    }
}
