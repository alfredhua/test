package com.leetcode.test.binarySearch;

/**
 * Created by guozhenhua
 * date 2020/5/22.
 */
public class Test1 {

    static int binarySearch(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]==target){
                return mid;
            }
            if (nums[mid]<target){
                left=mid+1;
            }
            if (nums[mid] > target){
                right=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1,2,3,5,7,10,12}, 7));;
    }
}
