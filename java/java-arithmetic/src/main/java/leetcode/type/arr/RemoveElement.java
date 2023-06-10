package leetcode.type.arr;

public class RemoveElement {

    public static void main(String[] args) {

        int[] nums = new int[]{3,3,4,4};
        int result = new RemoveElement().removeElement(nums,3);
        System.out.println(result);

    }

    public int removeElement(int[] nums, int val) {
        int k =0;
        for (int i =0;i<nums.length;i++){
            if (nums[i] != val){
                k++;
                continue;
            }
            nums[i] = 0;
        }
        return k;
    }
}
