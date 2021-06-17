package com.leetcode.arr;

import java.util.Arrays;

public class TwoSumTest {

    public static void main(String[] args) {

        int[] a=new int[]{2,7,11,15};

        final int[] ints = twoSum(a, 26);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }


    public static int[] twoSum(int[] arr, int sum){
        for (int i=0;i<arr.length;i++){
            int target=sum-arr[i];

            //剩下的是一个二分查找
            int left= i+1;
            int right =arr.length-1;

            while (left<=right){
                int mid=left+(right-left)/2;
                if (target<arr[mid]){
                    right=mid-1;
                    continue;
                }

                if (target>arr[mid]){
                    left=mid+1;
                    continue;
                }
                if (target==arr[mid]){
                    return new int[]{i,mid};
                }
            }
        }
        return new int[]{};
    }
}
