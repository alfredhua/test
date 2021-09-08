package com.leetcode.first;

public class J26 {


    public static void main(String[] args) {

        System.out.println(new J26().removeDuplicates(new int[]{1,1,2,3,3,3,4,4,5}));

    }

    public int removeDuplicates(int[] nums) {

        int preIndex =0;

        int nextIndex =1;

        while (nextIndex<nums.length){
            if (nums[preIndex]==nums[nextIndex]){
                nextIndex++;
            }else{
                int temp=nums[preIndex+1];
                nums[preIndex+1]=nums[nextIndex];
                nums[nextIndex] =temp;
                nextIndex++;
                preIndex++;
            }
        }
//        System.out.println(nums);
        return preIndex+1;

    }

}
