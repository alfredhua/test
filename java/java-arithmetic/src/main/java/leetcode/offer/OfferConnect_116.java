package leetcode.offer;

import leetcode.editor.helper.Node;

import java.util.LinkedList;
import java.util.Queue;

public class OfferConnect_116 {

    public static void main(String[] args) {
        Node node = new Node(1,
                new Node(2, new Node(4), new Node(5), null),
                new Node(3, new Node(6), new Node(7), null),
                null);
        System.out.println(new OfferConnect_116().connect(node));
    }


    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                Node node = queue.poll();
                if (node!=null) {
                    if (i < size - 1) {
                        node.next = queue.peek();
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
        }
        return root;
    }
}
