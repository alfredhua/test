package com.leetcode.first;

public class J110 {

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }else {
            return Math.abs(height(root.left)-height(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode treeNode){
        if (treeNode==null){
            return 0;
        }
        return Math.max(height(treeNode.left),height(treeNode.right))+1;
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
