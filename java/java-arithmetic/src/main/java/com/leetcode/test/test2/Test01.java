package com.leetcode.test.test2;

/**
 * Created by guozhenhua
 * date 2020/7/9.
 */
public class Test01 {

    public static void main(String[] args) {
        int a[]={1,3};
            System.out.println( insert(a, 2));

    }


    public static int insert(int[] nums, int target){
       int j=0;
       for (int i=0;i<nums.length;i++){
           if (nums[i]<target){
           }else{
               j=i;
               break;
           }
       }
       return j;
    }
}
