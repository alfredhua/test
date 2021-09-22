package com.leetcode.first;

public class J104 {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if ( root ==null){
            return 0;
        }
        int leftDep=maxDepth(root.left);
        int rightDep=maxDepth(root.right);
        return Math.max(leftDep,rightDep)+1;
    }
}
