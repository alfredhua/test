package leetcode.offer2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class OfferCombinationSum_39 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(candidates,target,0,ans,new ArrayDeque<>());
        return ans;
    }


    private void dfs(int[] candidates,int target, int begin,List<List<Integer>> ans,Deque<Integer> deque){
        if (target<0){
            return;
        }
        if (target==0){
            ans.add(new ArrayList<>(deque));
            return;
        }
        for (int i=begin;i<candidates.length;i++){
            deque.add(candidates[i]);
            dfs(candidates,target-candidates[i],i,ans,deque);
            deque.removeLast();
        }
    }

//    private void dfs(int[] candidates,int target, int index,List<List<Integer>> ans,List<Integer> prem){
//        if(index == candidates.length){
//            return;
//        }
//        if (target==0){
//            ans.add(new ArrayList<>(prem));
//            return;
//        }
//        dfs(candidates,target,index+1,ans,prem);
//        if (target - candidates[index]>=0){
//            prem.add(candidates[index]);
//            dfs(candidates,target-candidates[index],index,ans,prem);
//            prem.remove(prem.size()-1);
//        }
//    }
}
