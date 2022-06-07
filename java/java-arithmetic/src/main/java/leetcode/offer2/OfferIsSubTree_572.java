package leetcode.offer2;

import leetcode.editor.helper.TreeNode;

public class OfferIsSubTree_572 {
    public static void main(String[] args) {

    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }

    public boolean dfs(TreeNode root, TreeNode subRoot){
        if ( root == null){
            return false;
        }
        return check(root,subRoot) || dfs(root.left,subRoot) || dfs(root.right,subRoot);
    }

    public  boolean check(TreeNode root,TreeNode subRoot){
        if (root==null && subRoot==null){
            return true;
        }
        if (root==null || subRoot==null|| root.val!=subRoot.val){
            return false;
        }
        return check(root.left,subRoot.left) && check(root.right,subRoot.right);
    }

}
