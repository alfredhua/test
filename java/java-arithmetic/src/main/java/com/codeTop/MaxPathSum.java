package com.codeTop;

import leetcode.helper.TreeNode;

public class MaxPathSum {

    public static void main(String[] args) {

    }

    public int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return sum;
    }


    public int maxGain(TreeNode treeNode){
        if (treeNode==null){
            return 0;
        }

        int left =Math.max(maxGain(treeNode.left) , 0);
        int right =Math.max(maxGain(treeNode.right) , 0);
        int path = left + right + treeNode.val;
        sum = Math.max(path,sum);
        return treeNode.val + Math.max(left, right);
    }
}
