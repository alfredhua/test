package com.leetcode.test1.chapter00004;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 中位数是 (2 + 3)/2 = 2.5
 */
public class Solution {

  private double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] result = new int[nums1.length+nums2.length];
    int i=0,j=0,a=0;
    while (a!=(nums1.length+nums2.length)){
      if (i==nums1.length){
         while (j!=nums2.length){
           result[a]=nums2[j];
           a++;
           j++;
         }
        break;
      }
      if (j==nums2.length){
        while (i!=nums1.length){
          result[a]=nums1[i];
          a++;
          i++;
        }
        break;
      }
      if (nums1[i]<nums2[j]){
        result[a]=nums1[i];
        i++;
      }else{
        result[a]=nums2[j];
        j++;
      }
      a++;
    }

    if (a % 2 == 0) {
      return (result[a / 2 - 1] + result[a / 2]) / 2.0;
    } else {
      return result[a / 2];
    }

  }

  public static void main(String[] args) {
//    int[] nums1 = {1, 3},nums2 ={2};
    int[] nums1 = {1, 2},nums2 ={3,4};
    final double medianSortedArrays = new Solution().findMedianSortedArrays(nums1, nums2);
    System.out.println(medianSortedArrays);

  }
}
