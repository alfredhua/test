package com.leetcode.test;

public class HalfSearch {


    public static void main(String[] args) {
        Integer[] arr={9};
        int search= 5;
        System.out.println(search(arr,search));
    }


    private static Integer search(Integer[] arr,Integer search){
        int left=0,right=arr.length-1,mid;
        while (left<right){
            mid=(right+left)/2;
            if (search<arr[mid]){
                //在左边
                right=mid-1;
            }
            if (search>arr[mid]){
                //在右边
                left=mid+1;
            }
            if (search==arr[mid]){
                //正好
                return mid;
            }
        }

        return -1;

    }
}
