package com.leetcode.test;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums=new int[]{10,1,5,2,6,8,9,12,16,14};
        int[] ints = quickSort(nums, 0, nums.length - 1);
        for (int anInt : ints) {
            System.out.print(anInt+",");
        }
    }

    public static int[] quickSort(int[] nums,int left,int right){
        if (left<right){
            int partitionIndex=getPartition(nums,left,right);
            quickSort(nums, left, partitionIndex - 1);
            quickSort(nums, partitionIndex + 1, right);
        }
        return nums;
    }

    private static int getPartition(int[] nums,int left,int right){
        int pivot = left;
        int index = pivot + 1;
        for (int i=index;i<=right;i++){
            if (nums[i]<nums[pivot]){
                swap(nums, i, index);
                index++;  //为了寻找到基准的下标
            }
        }
        //将基准数据位置放到指定的index位置上，此时 的index位置就是基准位置
        swap(nums, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}