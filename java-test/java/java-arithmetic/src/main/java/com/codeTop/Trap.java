package com.codeTop;

public class Trap {

    public static void main(String[] args) {

    }


    public int trap(int[] height) {

        int n = height.length;

        // 左边最大
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i =1;i<n;i++){
            leftMax[i] = Math.max(leftMax[i-1],leftMax[i]);
        }

        // 右边最大
        int[] right = new int[n];
        right[n-1] = height[n-1];
        for (int i = n-2;i>n;i--){
            right[i] = Math.max(right[n+1],right[i]);
        }

        int ans = 0;
        for (int i =0;i<n;i++){
            ans = ans+ Math.min(leftMax[i],right[i]) - height[i];
        }
        return ans;
    }
}
