package leetcode.offer;

import java.util.List;

public class OfferMinimumTotal_120 {

    public static void main(String[] args) {

    }


    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size()==1){
            return triangle.get(0).get(0);
        }
        int[][] dp=new int[triangle.size()][triangle.size()];
        dp[0][0]=triangle.get(0).get(0);
        for (int i=1;i<triangle.size();i++){
            List<Integer> list = triangle.get(i);
            //第一个
            dp[i][0]=dp[i-1][0]+list.get(0);
            for (int j=1;j<i;j++){
                dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + list.get(j);
            }
            //最后一个
            dp[i][i]=dp[i-1][i-1]+list.get(i);
        }
        int result = dp[triangle.size()-1][0];
        for (int i=1;i<triangle.size();i++){
            result = Math.min(result, dp[triangle.size()-1][i]);
        }
        return result;
    }




    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle.size()==1){
            return triangle.get(0).get(0);
        }
        int result=triangle.get(0).get(0);
        int index=0;
        for (int i=1;i<triangle.size();i++){
            List<Integer> list = triangle.get(i);
            if (list.get(index)<list.get(index+1)){
                result=result+list.get(index);
            }else{
                result=result+list.get(index+1);
                index=index+1;
            }
        }
        return result;
    }
}
