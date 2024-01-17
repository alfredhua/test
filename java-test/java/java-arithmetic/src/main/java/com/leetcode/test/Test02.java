package com.leetcode.test;

import java.util.Arrays;

/**
 * @author guozhenhua
 * @date 2021/07/06
 *
 * 输入：[ 10,9,2,5,3,7,101,18 ]
 * 结果：[2,3,7,101 ]    4
 * 时间复杂度：O(nlogN)
 */
public class Test02 {

    public static void main(String[] args){

        int[] a={10,9,2,5,3,7,101,18};
        int i = get(a);
        System.out.println(i);
    }

    public static int get(int[] nums ){
        int[] deep=new int[nums.length];
        Arrays.fill(deep, 1);

        //后面指针
        for (int i=0;i<nums.length;i++) {

            //前面指针
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j]){
                    deep[i] =Math.max(deep[i],deep[j]+1);
                }
            }
        }
        int result=0;
        for (int i=0;i<deep.length;i++){
            result=Math.max(result,deep[i]);
        }

        return result;
    }

   public static int maxLength(int[] nums){
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
}
