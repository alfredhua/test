package leetcode.helper;

/**
 * @author guozhenhua7
 */
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode() {}
	public TreeNode(int val) { this.val = val; }
	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}


	public static  TreeNode getTreeNode(){
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);

		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);

		treeNode.right.left = new TreeNode(6);
		treeNode.right.right = new TreeNode(7);
		return treeNode;
	}
}
