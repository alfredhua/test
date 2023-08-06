package com.codeTop;

import leetcode.helper.TreeNode;

import java.util.*;

public class ZigzagLevelOrder {

    public static void main(String[] args) {

    }

    public List<Integer> dfs(TreeNode root,List<List<Integer>> result ){
        List<Integer> re = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            for (int i =0;i<queue.size();i++){
                TreeNode curNode = queue.poll();
                re.add(curNode.val);
                if (curNode.left != null) queue.add(curNode.left);
                if (curNode.right != null) queue.add(curNode.right);
            }
            if (result.size() % 2 == 1) Collections.reverse(re);
            result.add(re);
        }
        return  re;
    }
}
