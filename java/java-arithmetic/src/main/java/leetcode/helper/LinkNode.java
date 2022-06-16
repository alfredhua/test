package leetcode.helper;

/**
 * @author guozhenhua7
 */
public class LinkNode {
    public int value;
    public LinkNode pre;
    public LinkNode next;

    public LinkNode() {}

    public LinkNode(int value, LinkNode pre, LinkNode next) {
        this.value = value;
        this.pre = pre;
        this.next = next;
    }

}