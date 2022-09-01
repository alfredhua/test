package leetcode.codeTop;

import leetcode.helper.ListNode;

import java.util.HashSet;
import java.util.Set;

public class CodeTop_14_141 {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

}
