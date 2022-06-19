package leetcode.treenode;

import leetcode.helper.TreeNode;
import lombok.Data;

/**
 * 是否是平衡二叉树
 * 1. 左子树是
 * 2、右子树是
 * 3、左 与右高度差不超过1
 */
public class BalanceTreeTest {
    public static void main(String[] args) {
        boolean test = new BalanceTreeTest().test(TreeNode.getTreeNode());
        System.out.println(test);

    }

    public boolean test(TreeNode treeNode){
        return dfs(treeNode).isBalance;
    }
    
    public TreeReturnType dfs(TreeNode treeNode){
        if (treeNode==null){
            return  new TreeReturnType(true,0);
        }
        TreeReturnType left = dfs(treeNode.left);
        TreeReturnType right = dfs(treeNode.right);
        int height = Math.max(left.height,right.height);
        boolean balance = left.isBalance && right.isBalance &&
                Math.abs(left.height-right.height) <2;
        return new TreeReturnType( balance,height+1);
    }
    
    

    @Data
    static class TreeReturnType  {
        
        boolean isBalance;
        
        int height;

        public TreeReturnType(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }

}
