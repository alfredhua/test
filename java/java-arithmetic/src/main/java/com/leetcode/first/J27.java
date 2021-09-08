package com.leetcode.first;

public class J27 {

    public static void main(String[] args) {

        System.out.println(new J27().removeElement(new int[]{3,2,2,3},3));

    }

    public int removeElement(int[] nums, int val) {
        int left=0;
        for (int right=0;right<nums.length;right++){
            if (nums[right]!=val){
                nums[left]=nums[right];
                left++;
            }
        }
        return left;
    }
}
