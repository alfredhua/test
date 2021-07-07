package com.leetcode;

public class QuickSort2 {

    public static void main(String[] args) {
        int[] nums=new int[]{10,1,5,2,6,8,9,12,16,14};
        int[] ints = quickSort(nums, 0, nums.length - 1);
        for (int anInt : ints) {
            System.out.print(anInt+",");
        }
    }


    private static int[] quickSort(int[] nums,int left,int right){
        if (left<right){
            int pr=getPat(nums,left,right);
            quickSort(nums,left,pr-1);
            quickSort(nums,pr+1,right);
        }
        return nums;
    }


    private static int getPat(int[] nums,int left,int right){
        int pre=left;
        int index=left+1;
        for (int i=index;i<=right;i++){
            if (nums[i]<nums[pre]){
                swap(nums,i,index);
                index++;
            }
        }
        swap(nums,pre,index-1);
        return index-1;
    }


    private static void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}