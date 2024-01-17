package leetcode.offer2;

import java.util.ArrayList;
import java.util.List;

public class OfferGenerateParenthesis_22 {
    public static void main(String[] args) {

    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs("", n, n, ans);
        return ans;
    }

    private void dfs(String curStr,int left,int right,List<String> ans){
        if (left==0 && right==0){
            ans.add(curStr);
            return;
        }
        if (left>right){
            return;
        }
        if (left>0){
            dfs(curStr+"(",left-1,right,ans);
        }
        if (right>0){
            dfs(curStr+")",left,right-1,ans);
        }
    }

}
