package leetcode.review.listnode;

import leetcode.helper.ListNode;

public class RotateRight {

    public static void main(String[] args) {

    }

    public ListNode rotateRight(ListNode head, int k) {
        int x =0;
        // 闭合成了一个环
        ListNode temp = head;
        while (temp.next !=null){
            temp = temp.next;
            x++;
        }
        int add = x - k % x;
        if (add == x) {
            return head;
        }
        temp.next = head;
        while (add-- > 0) {
            temp = temp.next;
        }
        ListNode ret = temp.next;
        temp.next = null;

        return ret;
    }
}
