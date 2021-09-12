package com.leetcode.first;

public class J70 {

    public static void main(String[] args) {
        System.out.println(new J70().climbStairs(3));

    }

    public int climbStairs(int n) {
        int first =0, second =1;
        int result =0;

        for (int i=0;i<=n;i++){
            first = second;
            second = result;
            result = first + second;
        }

        return result;

    }
}
