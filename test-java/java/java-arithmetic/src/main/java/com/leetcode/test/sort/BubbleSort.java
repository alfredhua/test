package com.leetcode.test.sort;

/**
 * @author guozhenhua
 * @date 2021/07/06
 */
public class BubbleSort {

    public static void main(String[] args){
        int[] nums={1,2,8,5,9,10,4};
        int[] ints = bubbleSort(nums);
        for (int anInt : ints) {
            System.out.print(anInt+",");
        }
    }

    public static int[] bubbleSort(int[] nums){
        for (int i=1;i<nums.length;i++){
            for (int j=0;j<nums.length-i;j++){
                if (nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        return nums;
    }
}
