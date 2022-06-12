package leetcode.offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OfferPermuteUnique_47 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new OfferPermuteUnique_47().permuteUnique(new int[]{1, 2, 3,2});
        for (int i=0;i<lists.size();i++){
            List<Integer> integers = lists.get(i);
            for (int j=0;j<integers.size();j++){
                System.out.print(integers.get(j)+",");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] exists=new boolean[nums.length];
        backtrack(nums,ans,0,new ArrayList<>(),exists);
        return ans;
    }

    private void backtrack(int[] nums,List<List<Integer>> ans, int idx,List<Integer> per,boolean[] exists){
        if (idx == nums.length) {
            ans.add(new ArrayList<>(per));
            return;
        }
        for (int i =0;i<nums.length;i++){
            if (exists[i] || (i>0 && nums[i] == nums[i-1] && !exists[i-1])){
                continue;
            }
            per.add(nums[i]);
            exists[i] = true;
            backtrack(nums,ans,idx+1,per,exists);
            exists[i] = false;
            per.remove(idx);
        }
    }
}
