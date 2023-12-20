package leetcode.review.arr;

public class RemoveElement {
    public static void main(String[] args) {

    }

    public int removeElement(int[] nums, int val) {
        int left =0;
        for (int right =0;right<nums.length;right++){
            if (nums[right] != val){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
