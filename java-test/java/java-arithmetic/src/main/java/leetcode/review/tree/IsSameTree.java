package leetcode.review.tree;

import leetcode.helper.TreeNode;

public class IsSameTree {


    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode();
        TreeNode treeNode1 = TreeNode.getTreeNode();
        boolean sameTree = new IsSameTree().isSameTree(treeNode, treeNode1);
        System.out.println(sameTree);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p!=null && q!=null && p.val == q.val){
            boolean sameTree1 = isSameTree(p.left, q.left);
            boolean sameTree2 = isSameTree(p.right, q.right);
            return sameTree1 && sameTree2;
        }
        if (p==null && q==null){
            return true;
        }
        return false;
    }
}
