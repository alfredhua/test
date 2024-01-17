package leetcode.offer2;

public class OfferMinSubArrayLen_209 {
    public static void main(String[] args) {
        int i = new OfferMinSubArrayLen_209().minSubArrayLen( 4,new int[]{1, 4, 4});
        System.out.println(i);

        int j = new OfferMinSubArrayLen_209().minSubArrayLen( 7,new int[]{2,3,1,2,4,3});
        System.out.println(j);

    }

    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int start =0,end=0;
        int temp = 0,result=Integer.MAX_VALUE;
        while (end<nums.length){
            temp = temp + nums[end];
            while(temp>=target){
                result =Math.min(result,end-start+1);
                temp = temp - nums[start];
                start++;
            }
            end++;
        }
        return result==Integer.MAX_VALUE?0:result;
    }

}
