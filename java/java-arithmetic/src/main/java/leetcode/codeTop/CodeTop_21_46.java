package leetcode.codeTop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CodeTop_21_46 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length<1){
            return result;
        }
        Queue<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        dfs(0,path,used,result,nums);
        return result;
    }

    private void dfs(int start,Queue<Integer> queue,boolean[] used,List<List<Integer>> result,int[] nums ){
        if (queue.size()==nums.length){
            result.add(new ArrayList<>(queue));
            return;
        }
        for (int i = start;i<nums.length;i++){
            if (!used[i]) {
                queue.add(nums[i]);
                used[i]=true;
//                dfs(start, nums, queue, result, used);
                used[i]=false;
                queue.remove(nums[i]);
            }
        }
    }


}
