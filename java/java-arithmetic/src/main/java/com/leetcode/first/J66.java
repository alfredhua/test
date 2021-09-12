package com.leetcode.first;

import java.util.Arrays;

public class J66 {
    public static void main(String[] args) {
        System.out.println(Arrays.stream(new J66().plusOne(new int[]{9})));
    }

    public int[] plusOne(int[] digits) {
        int right=digits.length -1;

        while (right>=0){
            int num =digits[right];
            if (num+1>=10){
                digits[right]= (num+1)% 10;
            }else{
                digits[right]=num+1;
                return digits;
            }
            right--;
        }

        digits=new int[digits.length+1];
        digits[0] =1;
        return digits;
    }

}
