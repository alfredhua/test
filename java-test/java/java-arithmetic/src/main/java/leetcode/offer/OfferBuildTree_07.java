package leetcode.offer;

import leetcode.helper.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class OfferBuildTree_07 {

    //存放，inorder中的位置, value ------  index
    private Map<Integer, Integer> indexMap=new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0;i< inorder.length;i++){
            indexMap.put(inorder[i],i);
        }
        return recur(preorder,inorder,0,preorder.length-1,0,preorder.length-1);
    }

    public TreeNode recur(int[] preorder,int[] inorder, int preLeftIndex,int preRightIndex, int inLeftIndex,int inRightIndex){
        if (preLeftIndex > preRightIndex) {
            return null;
        }
        // 当前根节点
        TreeNode rootNode = new TreeNode(preorder[preLeftIndex]);
        // 中序遍历中的节点的位置
        int inorderRootIndex = indexMap.get(preorder[preLeftIndex]);
        int subLeftTreeIndex = inorderRootIndex - inLeftIndex;  // 左边节点
        // 左子树
        rootNode.left= recur(preorder,inorder,preLeftIndex+1,preLeftIndex+subLeftTreeIndex,inLeftIndex,inorderRootIndex-1);
        rootNode.right= recur(preorder,inorder,preLeftIndex+subLeftTreeIndex+1,preRightIndex,inorderRootIndex+1,inRightIndex);
        return rootNode;
    }

}
