package com.leetcode.dynamic;

import java.util.Arrays;

/**
 * Created by guozhenhua
 * date 2020/5/26.
 * 最长上升子序列
 * [10,9,2,5,3,7,101,18]
 * [2,3,7,101]    4
 * O(nlogN)
 */
public class Test2 {

    static int maxLength(int[] nums){

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            //后面的
            for (int j = 0; j < i; j++) {
                //前面的
                if (nums[i] > nums[j])
                    //如果前面存在比后面的大的时候，这个最长长度就是i到j的长度
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxLength(new int[]{10,9,2,5,3,7,101,18}));;
    }
}
