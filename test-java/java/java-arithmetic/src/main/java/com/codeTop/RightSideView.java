package com.codeTop;

import leetcode.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {


    public static void main(String[] args) {

    }

    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs (root,0);
        return  res;
    }

    public void dfs(TreeNode treeNode,int deep){
        if (treeNode == null) {
            return;
        }
        if (deep == res.size()){
            res.add(treeNode.val);
        }
        deep =deep+1;
        if (treeNode.right!=null){
            dfs(treeNode.right,deep);
        }
        if (treeNode.left!=null){
            dfs(treeNode.left,deep);
        }
    }
}
