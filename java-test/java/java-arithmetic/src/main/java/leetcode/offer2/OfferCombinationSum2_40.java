package leetcode.offer2;

import java.util.*;

public class OfferCombinationSum2_40 {

    public static void main(String[] args) {
        List<List<Integer>> lists = new OfferCombinationSum2_40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,0,ans,new ArrayDeque());
        return ans;
    }

    private void dfs(int[] candidates, int target, int begin, List<List<Integer>> ans, Deque<Integer> deque){
        if (target<0){
            return;
        }
        if (target==0){
            ans.add(new ArrayList<>(deque));
            return;
        }
        for (int i=begin;i<candidates.length;i++){

            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            deque.addLast(candidates[i]);
            dfs(candidates,target-candidates[i],i+1,ans,deque);
            deque.removeLast();
        }
    }

}
