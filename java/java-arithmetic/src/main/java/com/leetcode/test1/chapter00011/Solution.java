package com.leetcode.test1.chapter00011;

class Solution {
    public int maxArea(int[] height) {
        int start =0,end =height.length-1;
        int maxarea=0;
        while (start<end){
            maxarea = Math.max(maxarea, Math.min(height[start], height[end]) * (end - start));
            if (height[start] < height[end])
                start++;
            else
                end--;
        }
        return maxarea;
    }

    public static void main(String[] args) {
        int[] a={1,8,6,2,5,4,8,3,7};
        int i = new Solution().maxArea(a);
        System.out.println(i);
    }
}