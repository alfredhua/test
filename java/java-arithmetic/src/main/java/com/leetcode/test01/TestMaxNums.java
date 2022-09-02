package com.leetcode.test01;

/**
 * int[]
 * 最大子集 数组下标，一个或者多个元素，返回最大的和
 *
 */
public class TestMaxNums {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        System.out.println(new TestMaxNums().getMax(nums1));
        int[] nums2 = {-1,-2,-3};
        System.out.println(new TestMaxNums().getMax(nums2));
        int[] nums3 = {10,-2,8};
        System.out.println(new TestMaxNums().getMax(nums3));
        int[] nums4 = {10,-12,8};
        System.out.println(new TestMaxNums().getMax(nums4));
    }


    public int getMax(int[] nums){
        int[] resultNums = new int[nums.length];
        resultNums[0] = nums[0];
        for (int i =1;i<nums.length;i++){
            int current = resultNums[i-1]+ nums[i];
            if (current > nums[i]){
                resultNums[i] = current;
            }else{
                resultNums[i]  = nums[i];
            }
        }
        int result =Integer.MIN_VALUE;
        for (int k=0;k<resultNums.length;k++){
            result = Math.max(result,resultNums[k]);
        }
        return result;
    }

}
