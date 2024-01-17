package com.leetcode.test.sort;

/**
 * @author guozhenhua
 * @date 2021/07/06
 */
public class SelectionSort {

    public static void main(String[] args){
        int[] nums={5,2,8,1,9,10,4};
        int[] ints = selectSort(nums);
        for (int anInt : ints) {
            System.out.print(anInt+",");
        }

    }

    public static int[] selectSort(int[] nums){

        for (int i=0;i<nums.length-1;i++){
            int min = i; //当前的i是最小的
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    //记录目前能找到的最小值元素的下标
                    min = j;
                }
            }
            if (i != min) {
                int tmp = nums[i];
                nums[i] = nums[min];
                nums[min] = tmp;
            }
        }
        return nums;
    }
}
