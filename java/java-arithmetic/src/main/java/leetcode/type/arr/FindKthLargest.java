package leetcode.type.arr;

import java.util.Arrays;

public class FindKthLargest {

    public static void main(String[] args) {

    }

    public int findKthLargest(int[] nums,int k){
        int mid = nums.length/2;
        int[] leftNums = Arrays.copyOfRange(nums, 0, mid);
        int[] rightNums = Arrays.copyOfRange(nums, mid, nums.length);
        merge(leftNums,rightNums);
        return 0;
    }

    public void merge(int[] left, int[] right){
        int[] nums = new int[left.length+right.length];
        int leftIndex =0;
        int rightIndex =0;
        int k =0;
        while (leftIndex<left.length && rightIndex< right.length){
            if (left[leftIndex]<=right[rightIndex]){
                nums[k] = right[rightIndex];
                rightIndex++;
            }
            if (left[leftIndex]>right[rightIndex]){
                nums[k] = left[leftIndex];
                leftIndex++;
            }
            k++;
        }
        if (leftIndex==left.length){
            while (rightIndex<right.length){
                nums[k++]= nums[rightIndex];
                rightIndex++;
            }
        }
        if (rightIndex == right.length){
            while (leftIndex<left.length){
                nums[k++]= nums[leftIndex];
                leftIndex++;
            }
        }

    }

}
