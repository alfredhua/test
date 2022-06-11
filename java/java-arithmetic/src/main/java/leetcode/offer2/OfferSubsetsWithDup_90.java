package leetcode.offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OfferSubsetsWithDup_90 {

    List<Integer> t = new ArrayList<>();
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false,0,nums);
        return lists;
    }

    public void dfs(boolean choosePre, int cur, int[] nums){
        if (cur == nums.length){
            lists.add(new ArrayList<>(t));
            return;
        }
        dfs(false,cur+1,nums);
        if (!choosePre && cur >0 && nums[cur-1] == nums[cur]){
            return;
        }
        t.add(nums[cur]);
        dfs(true,cur+1,nums);
        t.remove(t.size()-1);
    }
}
