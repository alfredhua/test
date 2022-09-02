package leetcode.codeTop;

import leetcode.helper.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 */
public class CodeTop_19_236 {


    public static void main(String[] args) {

    }

    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    public void dfs(TreeNode root){
        if (root.left!=null){
            parent.put(root.left.val,root);
            dfs(root.left);
        }
        if (root.right!=null){
            parent.put(root.right.val,root);
            dfs(root.right);
        }
    }


    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        boolean b = this.dfs1(root, p, q);
        return ans;
    }
    private TreeNode ans;
    public boolean dfs1(TreeNode root,TreeNode p, TreeNode q){
        if (root==null){
            return false;
        }
        boolean lson = dfs1(root.left,p,q);
        boolean rson = dfs1(root.right,p,q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }


}
