package leetcode.type.arr;

public class RemoveDuplicates2 {


    public static void main(String[] args) {
//        int[] nums = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 5, 6, 7};
        int[] nums = new int[]{1,1,1,2,2,2,3,4,4,4};
        int count = new RemoveDuplicates2().removeDuplicates(nums);
        System.out.println(count);
    }

    public int removeDuplicates(int[] nums) {
        int slow =0;
        for (int fast =0;fast<nums.length;fast++){
            if (slow < 2 || nums[fast]!=nums[slow-2]){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

}
