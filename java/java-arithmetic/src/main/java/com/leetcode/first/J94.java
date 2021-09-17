package com.leetcode.first;

import java.util.ArrayList;
import java.util.List;

public class J94 {

    public static void main(String[] args) {

    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        getNode(root,list);
        return list;
    }


    public void getNode(TreeNode node,List<Integer> list){
        if (node==null){
            return;
        }
        getNode(node.left,list);
        list.add(node.val);
        getNode(node.right,list);
    }
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
