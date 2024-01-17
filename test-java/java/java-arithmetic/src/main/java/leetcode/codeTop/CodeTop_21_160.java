package leetcode.codeTop;

import leetcode.helper.ListNode;

import java.util.HashSet;
import java.util.Set;

public class CodeTop_21_160 {

    public static void main(String[] args) {

        ListNode listNode1 = ListNode.createListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        ListNode listNode2 = ListNode.createListNode(new int[]{9,10,11,12, 6, 7, 8});
        ListNode intersectionNode1 = new CodeTop_21_160().getIntersectionNode1(listNode1, listNode2);
        System.out.println(intersectionNode1.val);

    }


    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<Integer> set = new HashSet<>();
        while (headA!=null){
            set.add(headA.val);
            headA=headA.next;
        }

        while (headB!=null){
            if (set.contains(headB.val)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
