package com.leetcode.test01;

import java.util.Arrays;

/**
 * @author hua
 * @date 2022/8/20
 */
public class Test01 {

    public static void main(String[] args) {
        int maxPrice = new Test01().getMaxPrice(new int[]{2, 3, 4, 5}, new int[]{1300, 2300, 1000, 5000}, 8);
        System.out.printf(String.valueOf(maxPrice));
    }

    /**
     *
     * @param w 重量
     * @param p 价值
     * @param v 背包重量
     * @return
     */
    public int getMaxPrice(int[] w,int[] p,int v){
        int len = w.length; //物品个数
        int[][] dp =new int[len][v+1];  //
        Arrays.fill(dp[0], 0);
        for (int i =1;i<len;i++){ //物品个数
            for (int j=0;j<=v;j++){ //重量
                if (j<w[i]){
                    //背包重量小于物品重量
                    dp[i][j] =dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],p[i]+dp[i-1][j-w[i]]);
                }
            }
        }
        return dp[w.length-1][v];
    }
}
