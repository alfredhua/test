package com.leetcode.first;

public class J53 {

    public static void main(String[] args) {
        System.out.println(new J53().maxSubArray(new int[]{-2,2,1,-3,4,-1,2,1,-5,4}));

    }

    public int maxSubArray(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        int max =nums[0];
        for (int i=0;i<nums.length;i++){
            int num=0;
            for (int j=i;j<nums.length;j++){
                 num = num+nums[j];
                 max = Math.max(max,num);
            }
        }
        return max;
    }
}
