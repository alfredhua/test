package com.codeTop;

import leetcode.helper.TreeNode;
import lombok.val;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestor {

    private static Map<Integer,TreeNode> parentNode = new HashMap<>();
    Set<Integer> visited = new HashSet<Integer>();

    public static void main(String[] args) {

    }

    public void dfs(TreeNode root){
        if (root.left!=null){
            parentNode.put(root.left.val,root);
            dfs(root.left);
        }

        if (root.right!=null){
            parentNode.put(root.right.val,root);
            dfs(root.right);
        }
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 遍历 node，存储所有的节点的父节点
        dfs(root);
        while (p!=null){
            visited.add(p.val); // 将 P 的所有父节点放进去
            p = parentNode.get(p.val);
        }
        while (q!=null){
            // 判断是否 有 Q 的父节点，第一次命中一定是最近的一个
            if (visited.contains(q.val)) {
                return q;
            }
            q = parentNode.get(q.val);
        }
        return null;
    }
}
