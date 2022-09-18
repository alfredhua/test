package leetcode.codeTop;

import leetcode.helper.ListNode;

import java.util.List;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 */
public class CodeTop_5_25 {


    public static void main(String[] args) {
        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        ListNode listNode1 = new CodeTop_5_25().reverseKGroup(listNode, 3);
        List<Integer> integers = listNode1.printListNode();
        System.out.println(integers);
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode end = dummy;
        ListNode pre = dummy;
        // pre ------- end 反转
        while (end.next!=null){
            for (int i =0;i<k;i++){
                end.next=end;
            }
            ListNode startNode = pre;
            ListNode next = end.next;
            end.next = null;
            pre.next  = reverse(startNode.next);
            end.next = next;
            pre = startNode;
            end = pre;
        }
        return dummy.next;
    }
























    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next!=null){
            // end 一直往下走，走到第k个，此时pre --- end 是需要反转的
            for (int i = 0; i<k && end!=null;i++){
                end = end.next;
            }
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

//    private ListNode reverse(ListNode head) {
//        ListNode pre = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode next = curr.next;
//            curr.next = pre;
//            pre = curr;
//            curr = next;
//        }
//        return pre;
//    }
    public ListNode reverse(ListNode head){
        if (head==null || head.next==null){
          return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next=head;
        head.next = null;
        return newHead;
    }

//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//
//        ListNode pre = dummy;
//        ListNode end = dummy;
//
//        while (end.next != null) {
//            for (int i = 0; i < k && end != null; i++) end = end.next;
//            if (end == null) break;
//            ListNode start = pre.next;
//            ListNode next = end.next;
//            end.next = null;
//            pre.next = reverse(start);
//            start.next = next;
//            pre = start;
//
//            end = pre;
//        }
//        return dummy.next;
//    }
//
//    private ListNode reverse(ListNode head) {
//        ListNode pre = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode next = curr.next;
//            curr.next = pre;
//            pre = curr;
//            curr = next;
//        }
//        return pre;
//    }
}
