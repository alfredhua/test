package leetcode.review.tree;

import leetcode.helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class MaxDepth {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode();
        int i = new MaxDepth().maxDepth(treeNode);
        System.out.println(i);
    }

    public int maxDepth(TreeNode root) {
        if (root!=null){
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
        return 0;
    }
    public int maxDepth2(TreeNode root) {
        if (root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int a = 0;
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            int size = queue.size();
            while (size>0) {
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            a++;
        }

        return a;
    }






}
