package leetcode.review.listnode;

import leetcode.helper.ListNode;

public class Reverse {


    public static void main(String[] args) {
        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5, 6});
//        ListNode reverse = new Reverse().reverse(listNode);
//        System.out.println(reverse.printListNode());

//        ListNode reverse2 = new Reverse().reverse2(listNode);
//        System.out.println(reverse2.printListNode());

        ListNode reverse3 = new Reverse().reverseBetween(listNode,2,4);
        System.out.println(reverse3.printListNode());
    }


    public ListNode reverse2(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        ListNode newHead = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverse(ListNode head) {
        ListNode result = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode nextNode = temp.next;
            temp.next = result;
            result = temp;
            temp = nextNode;
        }
        return result;
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        // 找到了开始节点
        ListNode pre = dummyNode;
        for (int i =0;i<left-1;i++){
            pre = pre.next;
        }
        // 找到了结束节点
        ListNode rightNode = pre;
        for (int i =0;i<right-left+1;i++){
            rightNode = rightNode.next;
        }
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;
        // 断开链接
        rightNode.next = null;
        pre.next = null;
        // 反转
        reverse(leftNode);

        // 重新链接
        pre.next = rightNode;
        leftNode.next = curr;

        return dummyNode.next;
    }
}
