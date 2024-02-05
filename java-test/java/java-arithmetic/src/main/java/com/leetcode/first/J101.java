package com.leetcode.first;

public class J101 {

    public static void main(String[] args) {

    }
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }

    public boolean check(TreeNode left,TreeNode right){
        if (left==null && right==null){
            return true;
        }
        if (left==null || right==null){
            return false;
        }

        return left.val== right.val && check(left.left,right.right) && check(left.right,right.left);
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