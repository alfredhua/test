package leetcode.offer;

public class OfferRob_198 {

    public static void main(String[] args) {
        int rob = new OfferRob_198().rob(new int[]{1, 2, 3, 1});
        System.out.println(rob);

    }

    public int rob(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        int[] max=new int[nums.length];
        max[0]=nums[0];
        max[1]=Math.max(nums[0],nums[1]);
        for (int i=2;i<nums.length;i++){
            max[i]=Math.max(max[i-2]+nums[i],max[i-1]);
        }
        return Math.max(max[max.length-1],max[max.length-2]);
    }

}
