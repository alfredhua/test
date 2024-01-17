package leetcode.offer;

import java.util.*;

public class OfferCombine_77 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList();
        if (k<1 || n<k){
            return result;
        }
        Deque<Integer> deque=new ArrayDeque<>();
        dfs(n,k,1,deque,result);
        return result;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=begin;i<=n;i++){
            path.add(i);
            dfs(n,k,i+1,path,res);
            path.removeLast();
        }
    }




}
