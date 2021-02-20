package com.leetcode.bsf;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by guozhenhua
 * date 2020/5/25.
 *  3
 * 9 20
 *  15 7
 */
public class Test {


    static int minDepth(TreeNode root) {

        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root 本身就是一层，depth 初始化为 1
        int depth = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll(); //root抛出
                /* 判断是否到达终点 */
                if (cur.left == null && cur.right == null)
                    return depth;
                /* 将 cur 的相邻节点加入队列 */
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            /* 这里增加步数 */
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        root.left=treeNode9;

        TreeNode treeNode20 = new TreeNode(20);
        root.right=treeNode20;

        treeNode20.left=new  TreeNode(15);
        treeNode20.right=new  TreeNode(7);
        System.out.println(minDepth(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
