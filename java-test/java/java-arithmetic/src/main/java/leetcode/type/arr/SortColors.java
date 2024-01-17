package leetcode.type.arr;

public class SortColors {


    public static void main(String[] args) {
        int[] nums = new int[]{0,2,1,2,1,2,0};
        new SortColors().sortColors(nums);
        System.out.println(nums);

    }

    public void sortColors(int[] nums) {
        int redIndex =0;
        int blueIndex = nums.length - 1;
        for (int i =0;i<blueIndex+1;i++){
            if(nums[i] == 0){
                //放在左边
                int temp = nums[redIndex];
                nums[redIndex++] = nums[i];
                nums[i] = temp;
            }
            if (nums[i] == 2){
                int temp = nums[blueIndex];
                nums[blueIndex--] = nums[i];
                nums[i] = temp;
                i--;
            }
        }
    }
}
