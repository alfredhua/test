package com.codeTop;

public class FindKthLargest {

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        findKthLargest.findKthLargest(new int[]{3,4,6,8,9,5,1,2},6);
    }

    public int findKthLargest(int[] nums, int k) {
        sort(nums,0,nums.length-1,k);
        return nums[k-1];
    }

    public void sort(int[] nums, int left, int right,int k){
        if (left<right){
            int index = getPartion(nums,left,right,k);
            sort(nums,left,index-1,k);
            sort(nums,index+1,right,k);
        }
    }

    public int getPartion(int[] nums,int left, int right,int k){
        int index = left +1;
        for (int i = index; i<=right;i++){
            if (nums[i]<nums[left]){
                //小的在左边，大的在右边
                swap(nums,i,index);
                index++;
            }
        }
        swap(nums,left,index-1);
        return 0;
    }


    public  void swap(int[] nums,int i , int index){
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}
