package com.leetcode.test.test1.chapter00001;


import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class Solution {

  /**
   * 俩次循环
   * @param nums
   * @param target
   * @return
   */
  private int[] twoSum1(int[] nums, int target) {
    int result[]=new int[2];
    for (int i=0;i<nums.length;i++) {
      for (int j=i+1;j<nums.length;j++) {
        if (target-nums[i]==nums[j]){
            result[0]=i;
            result[1]=j;
        }
      }
    }
    return result;
  }

  /**
   * 利用HashMap处理
   * @param nums
   * @param target
   * @return
   */
  private  int[] twoSum2(int[] nums,int target){
    Map<Integer, Integer> map=new HashMap<>();
    for (int i=0;i<nums.length;i++) {
      int a=target-nums[i];
      if(map.containsKey(a)){
        return new int[]{map.get(a),i};
      }
      map.put(nums[i],i);
    }
    return null;
  }


  public static void main(String[] args) {
    Solution s=new Solution();
    int num[] = { 11,2, 7, 15}, target = 9;
    int[] results = s.twoSum2(num, target);
    for (int a:results ) {
      System.out.print(a+",");
    }
  }


}
