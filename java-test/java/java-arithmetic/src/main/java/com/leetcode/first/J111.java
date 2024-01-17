package com.leetcode.first;

public class J111 {

    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        if (root.left==null && root.right==null){
            return 1;
        }
        int minDepth=Integer.MAX_VALUE;
        if (root.left!=null) {
            minDepth=Math.min(minDepth(root.left),minDepth);
        }
        if (root.right!=null){
            minDepth=Math.min(minDepth(root.right),minDepth);
        }
        return minDepth+1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
