package com.codeTop;

public class LengthOfLIS {

    public static void main(String[] args) {
        int i = new LengthOfLIS().lengthOfLIS(new int[]{0, 3, 1, 6, 2, 2, 7});
        System.out.println(i);
    }


    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int result = 0;
        for (int i =1;i<nums.length;i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
