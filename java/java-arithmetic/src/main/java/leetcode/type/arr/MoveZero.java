package leetcode.type.arr;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 */
public class MoveZero {


    public static void main(String[] args) {
        MoveZero moveZero = new MoveZero();
        int[] nums = new int[]{1,2,3,0,1,2,3};
//        moveZero.moveZeroes(nums);
//        moveZero.moveZeroes2(nums);
        moveZero.moveZeroes3(nums);
        System.out.println(nums);
    }

    public void moveZeroes3(int[] nums) {
        int k =0;
        for (int i = 0;i<nums.length;i++){
            if (nums[i]!=0){
                nums[k] = nums[i];
                k++;
            }
        }
        for (int i=k;i<nums.length;i++){
            nums[k] = 0;
        }

    }


    public void moveZeroes2(int[] nums) {
        int k =0;
        for (int i = 0;i<nums.length;i++){
            if (nums[i] !=0){
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                k++;
            }
        }

    }


    /**
     * 第一次循环，碰到是0 则和后面的第一个非0的元素换位置即可
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        for (int i =0;i<nums.length-1;i++){
            for (int j =i+1;j<nums.length;j++){
                if (nums[i] == 0 && nums[j]!=0){
                    int a = nums[i];
                    nums[i] = nums[j];
                    nums[j] = a;
                }
            }
        }
    }

}
