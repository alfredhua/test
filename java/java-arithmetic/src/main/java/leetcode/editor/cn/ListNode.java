package leetcode.editor.cn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListNode {
      Integer val;
      ListNode next;

    public ListNode() {
    }

    public ListNode(Integer val) {
        this.val = val;
    }

    public ListNode(Integer val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}