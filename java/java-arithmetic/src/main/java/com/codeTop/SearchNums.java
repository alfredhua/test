package com.codeTop;

public class SearchNums {

    public static void main(String[] args) {

        int search = new SearchNums().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        int low = 0;
        int hight = nums.length-1;
        
        while (low<=hight){
            int mid = (hight-low)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid]<nums[hight]){
                // 右边有序
                if (nums[mid]<target && target <= nums[hight]){
                    low =mid +1;
                }else {
                    hight = mid -1;
                }
            }else {
                // 左边有序
                if (nums[mid] > target && target >= nums[low]){
                    hight = mid -1;
                }else {
                    low =mid +1;
                }
            }
        }
        return  -1;
    }
}
