package leetcode.codeTop;

import leetcode.helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CodeTop_11_102 {

    public static void main(String[] args) {
        List<List<Integer>> lists = new CodeTop_11_102().levelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))));
        System.out.println("-------------"+lists.toArray());
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i =0;i<currentLevelSize;i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }


}
