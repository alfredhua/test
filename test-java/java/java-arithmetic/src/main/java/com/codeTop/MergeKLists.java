package com.codeTop;

import leetcode.helper.ListNode;

public class MergeKLists {


    public static void main(String[] args) {

    }

    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode ans = null;
        for (ListNode listNode:lists){
            ans = mergeTwoLists(ans,listNode);
        }
        return ans;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] listNodes,int left, int right){
        if (left == right) {
            return listNodes[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        return mergeTwoLists(merge(listNodes, left, mid), merge(listNodes, mid + 1, right));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

}
