package com.leetcode.first;

public class J27 {

    public static void main(String[] args) {

        System.out.println(new J27().removeElement(new int[]{3,2,2,3},3));

    }

    public int removeElement(int[] nums, int val) {
        int preIndex=0;
        int nextIndex=1;
        while (nextIndex<nums.length-1){
            if (nums[preIndex]==val){
                while (nextIndex<nums.length-1 && nums[nextIndex]==val){
                    nextIndex++;
                }
                int temp =nums[preIndex];
                nums[preIndex] = nums[nextIndex];
                nums[nextIndex]=temp;
                preIndex++;
            }else {
                preIndex++;
                nextIndex++;
            }
        }
        return preIndex;
    }
}
