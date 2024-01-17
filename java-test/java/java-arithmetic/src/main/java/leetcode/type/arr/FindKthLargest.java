package leetcode.type.arr;

public class FindKthLargest {

    public static void main(String[] args) {
        int[]  nums = new int[]{3,4,5,1,2,6};
        int kthLargest = new FindKthLargest().findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums,int k){
        get(nums,0,nums.length-1,k);
        return  nums[k-1];
    }

    public void get(int[] nums, int left, int right,int k){
        if (left<right){
            int partion = getPartion(nums, left, right);
                get(nums,left,partion-1,k);
            get(nums,partion+1,right,k);
        }
    }

    public int getPartion(int[] nums, int left, int right){
        // 比 mid 大的 放在左边，小的放在右边
        int index = left +1;
        for (int i =index;i<=right;i++){
            if (nums[i]>nums[left]){
                swap(nums,i,index);
                index ++;
            }
        }
        swap(nums,left,index-1);
        return index - 1;
    }

    public  void swap(int[] nums,int i , int index){
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}
