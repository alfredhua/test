package leetcode.codeTop;

import java.util.*;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class CodeTop_22_46 {

    public static void main(String[] args) {

        List<List<Integer>> permute = new CodeTop_22_46().permute(new int[]{1, 2, 3});
        for (List<Integer> a:permute){
            System.out.println(a.toString());
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length<1){
            return result;
        }
        Queue<Integer> queue= new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums,0,queue,result,used);
        return result;
    }

    private void dfs(int[] nums, int start, Queue<Integer> queue, List<List<Integer>> result,boolean[] used){
        if (queue.size()==nums.length){
            result.add(new ArrayList<>(queue));
            return;
        }
        for (int i =start;i<nums.length;i++){
            if (!used[i]){
                used[i]=true;
                queue.add(nums[i]);
                dfs(nums,start,queue,result,used);
                queue.remove(nums[i]);
                used[i] = false;
            }
        }
    }

}
