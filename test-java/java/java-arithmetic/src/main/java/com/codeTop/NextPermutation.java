package com.codeTop;

public class NextPermutation {

    public static void main(String[] args) {

    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        // 找出 num[i]M <num[i+1] 最大的索引
        int firstIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstIndex = i;
                break;
            }
        }
        if (firstIndex == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // 找出 num[i] > firstIndex 最大的索引
        int secondIndex = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[firstIndex]) {
                secondIndex = i;
                break;
            }
        }

        // 换位置
        swap(nums, firstIndex, secondIndex);

        // 反转
        reverse(nums, firstIndex + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int i1) {
        int tmp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = tmp;
    }

}
