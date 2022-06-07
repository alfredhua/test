package leetcode.offer2;

import leetcode.editor.helper.Node;

import java.util.LinkedList;
import java.util.Queue;

public class OfferConnect_117 {
    public static void main(String[] args) {

    }

    public Node connect(Node root){
        if (root ==null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Node last=null;
            for (int i=1;i<=size;i++) {
                Node poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                if (i!=1){
                    last.next = poll;
                }
                last = poll;
            }
        }
        return root;
    }
}
