package com.leetcode.first;

public class J88 {
    public static void main(String[] args) {

        int[] nums1= new int[]{1,2,3,0,0,0};
        int[] nums2= new int[]{1,2,3};
        new J88().merge(nums1,3,nums2,3);

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int[] result= new int[m+n];
        int current=0;
        while (p1<m || p2<n){
            if (p1==m){
                current=nums2[p2];
                p2++;
            }else  if (p2==n){
                current=nums1[p1];
                p1++;
            }else  if (nums1[p1]<nums2[p2]){
                current=nums1[p1];
                p1++;
            }else{
                current=nums2[p2];
                p2++;
            }

            result[p1+p2-1]=current;
        }
        for(int i=0;i<result.length;i++){
            nums1[i]=result[i];
        }
    }

}
