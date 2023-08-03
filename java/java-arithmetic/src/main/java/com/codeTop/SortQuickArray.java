package com.codeTop;

import java.util.Arrays;

public class SortQuickArray {

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,3,1,6,7,9,11,10};
        int[] ints = new SortQuickArray().quickSort(nums,0,nums.length-1);
        System.out.println(ints);
    }

    public int[] quickSort(int[] nums, int left, int right){
        if (left<right){
            int index = getIndex(nums,left,right);
            quickSort(nums,left,index-1);
            quickSort(nums,index+1,right);
        }
        return nums;
    }

    public int getIndex(int[] nums,int left, int right){
        int index = left +1;
        for (int i =index;i<=right;i++){
            // 换位置
            if (nums[i]>nums[left]){
                swap(nums,i,index);
                index++;
            }
        }
        swap(nums,index-1,left);
        return index-1;
    }


    public void swap(int[] nums,int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

