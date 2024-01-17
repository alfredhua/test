package com.codeTop;

import leetcode.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {


    public static void main(String[] args) {
        

    }

    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null){
            return ans;
        }
        inorderTraversal(root.left);
        ans.add(root.val);
        inorderTraversal(root.right);
        return ans;
    }
}
