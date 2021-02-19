package com.leetcode.test2;

/**
 * Created by guozhenhua
 * date 2020/5/21.
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 */
public class chapter00034 {

    public int[] search(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1; // 注意
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
//                return mid;
                return null;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return null;
    }

    public static void main(String[] args) {
        chapter00033 a=new chapter00033();
        int[] ac={4,5,6,7,0,1,2};
        a.search(ac,0);
    }


}
