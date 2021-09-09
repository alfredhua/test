package com.leetcode.first;

public class J35 {

    public static void main(String[] args) {
        int i = new J35().searchInsert(new int[]{1, 3, 5, 6}, 7);
        System.out.println(i);
    }

    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int ans=nums.length;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]<target){
                left=mid+1;
            }
            if (nums[mid]==target){
                return mid;
            }
            if (nums[mid]>target){
                ans=mid;
                right=mid-1;
            }
        }
        return ans;
    }
}
