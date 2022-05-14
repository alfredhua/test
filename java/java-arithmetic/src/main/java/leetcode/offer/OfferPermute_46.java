package leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OfferPermute_46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = new OfferPermute_46().permute(nums);
        System.out.println(lists);

    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        if (nums.length<1){
            return result;
        }
        Queue<Integer> path=new LinkedList<>();
        boolean[] used=new boolean[nums.length];
        dfs(0,nums,path,result,used);
        return result;
    }

    private void dfs(int start,int[] nums,Queue<Integer> path,List<List<Integer>> result,boolean[] used){
        if (path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i=start;i<nums.length;i++){
            if (!used[i]) {
                path.add(nums[i]);
                used[i]=true;
                dfs(start, nums, path, result, used);
                used[i]=false;
                path.remove(nums[i]);
            }
        }
    }


}
