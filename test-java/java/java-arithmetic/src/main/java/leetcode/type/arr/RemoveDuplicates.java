package leetcode.type.arr;

public class RemoveDuplicates {


    public static void main(String[] args) {
//        int[] nums = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 5, 6, 7};
        int[] nums = new int[]{1,1,1,2,2,2,3,4,4,4};
        int count = new RemoveDuplicates().removeDuplicates(nums);
        System.out.println(count);
    }

    public int removeDuplicates(int[] nums) {
        if (nums==null){
            return 0;
        }
        if (nums.length==1){
            return 1;
        }
        int slow = 0;
        for (int fast =1;fast<nums.length;fast++){
            if (nums[fast]!=nums[slow] && fast-slow>=2){
                slow = slow+1;
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
            }
        }
        return slow+1;
    }
}
