package leetcode.codeTop;

import leetcode.helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CodeTop_17_103 {

    public static void main(String[] args) {
        List<List<Integer>> lists = new CodeTop_17_103().zigzagLevelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))));
        System.out.println("-------------"+lists.toString());
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag=true;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i =0;i<size;i++){
                TreeNode poll = queue.poll();
                if (flag) {
                    if (poll.left!=null){
                        queue.add(poll.left);
                    }
                    if (poll.right!=null){
                        queue.add(poll.right);
                    }
                }else {
                    if (poll.right!=null) {
                        queue.add(poll.right);
                    }
                    if (poll.left!=null) {
                        queue.add(poll.left);
                    }
                }
                list.add(poll.val);
            }
            result.add(list);
            flag =!flag;
        }
        return result;
    }
}
