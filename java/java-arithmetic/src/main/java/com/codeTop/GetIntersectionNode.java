package com.codeTop;

import leetcode.helper.ListNode;

import java.util.HashMap;
import java.util.Map;

public class GetIntersectionNode {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<Integer,ListNode> map = new HashMap<>();
        while (headA!=null){
            map.put(headA.val,headA);
            headA = headA.next;
        }

        while (headB!=null){
            if (map.containsKey(headB.val)){
                return headB;
            }
            headB = headB.next;
        }
        return  null;

    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
