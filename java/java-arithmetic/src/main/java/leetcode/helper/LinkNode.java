package leetcode.helper;

import lombok.Getter;
import lombok.Setter;

/**
 * @author guozhenhua7
 */
@Getter
@Setter
public class LinkNode {
    public int value;
    public LinkNode pre;
    public LinkNode next;

    public LinkNode() {}

    public LinkNode(int value) {
        this.value = value;
    }

    public LinkNode(int value, LinkNode pre, LinkNode next) {
        this.value = value;
        this.pre = pre;
        this.next = next;
    }

}