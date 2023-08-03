package com.codeTop;

public class MaxSubArray {

    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];

        for (int i =1;i<nums.length;i++){
            if (dp[i-1]>0){
                dp[i] = dp[i-1]+nums[i];
            }else {
                dp[i] = nums[i];
            }
        }
        int result = 0;
        for (int i=0;i<dp.length;i++){
            result = Math.max(result,dp[i]);
        }
        return  result;

    }
}
