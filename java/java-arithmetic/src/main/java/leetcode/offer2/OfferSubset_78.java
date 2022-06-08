package leetcode.offer2;

import java.util.ArrayList;
import java.util.List;

public class OfferSubset_78 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0,nums,new ArrayList<>(),res);
        return res;
    }

    private void dfs(int cur,int[] nums,List<Integer> t,List<List<Integer>> res){
        res.add(new ArrayList<>(t));
        for (int i=cur;i<nums.length;i++){
            t.add(nums[i]);
            dfs(i+1,nums,t,res);
            t.remove(t.size()-1);
        }
    }
}
