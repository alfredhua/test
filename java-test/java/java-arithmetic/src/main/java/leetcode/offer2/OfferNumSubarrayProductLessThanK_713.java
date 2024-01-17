package leetcode.offer2;

public class OfferNumSubarrayProductLessThanK_713 {

    public static void main(String[] args) {
    }


    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k<=1){
            return 0;
        }
        int result = 0;
        int temp = 1,i=0;
        for (int j =0 ;j<nums.length;j++){
            temp *=nums[j];
            while (i<=j && temp>=k){
                temp /=nums[i];
                i++;
            }
            result +=j-i+1;
        }
        return result;
    }

}
