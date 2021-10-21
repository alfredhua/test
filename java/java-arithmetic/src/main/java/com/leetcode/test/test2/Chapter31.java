package com.leetcode.test.test2;

/**
 * @author guozhenhua
 * @date 2020/07/02
 */
public class Chapter31 {

    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        //从末尾与前一位进行比较
        while (i>=0 && nums[i+1]<=nums[i]){
            i--;
        }

        if (i>=0){
            //这个时候存在前一位比后一位大的数
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        //没有，将数组翻转即可,此时的i为-1，如果存在i>0,则为i+1的位置要倒排
        reverse(nums,i+1);

    }

    private void reverse(int[] nums,int start){
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
