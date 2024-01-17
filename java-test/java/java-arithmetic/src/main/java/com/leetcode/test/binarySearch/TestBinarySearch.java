package com.leetcode.test.binarySearch;

public class TestBinarySearch {

    public static void main(String[] args) {
//        System.out.println(new Test().getIndex1(new int[]{1,2,3,3,3,3,4,5,6,7},3));
        System.out.println(new TestBinarySearch().getIndex(new int[]{1,2,3,3,3,3,5,6,7},4));
    }


    public int getIndex1(int[] nums,int target){
        for (int i =0;i<nums.length;i++){
            if (nums[i]>target){
                return i;
            }
        }
        return -1;
    }


    public int getIndex(int[] nums,int target){
        int left = 0, right = nums.length-1;
        while (left<right){
            int mid = left + (right-left) /2;
            if (target < nums[mid]){
                //目标在左边
                right =mid-1;
            }
            if (target >= nums[mid]){
                //目标在右边
                left =mid+1;
            }
        }
        return left+1;
    }
}
