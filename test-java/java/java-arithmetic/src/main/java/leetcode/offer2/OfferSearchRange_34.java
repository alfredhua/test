package leetcode.offer2;

public class OfferSearchRange_34 {
    public static void main(String[] args) {
        int[] ints = new OfferSearchRange_34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.printf(ints.toString());
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result=new int[]{-1,-1};
        int left =0,right = nums.length-1;
        boolean rightFlag= false,leftFlag=false;
        while (left<=right){
            if (result[0]!=-1 && result[1]!=-1){
                break;
            }
            if(nums[left] == target && result[0] == -1){
                result[0] = left;
                leftFlag=true;
            }
            if (!leftFlag){
                left++;
            }

            if (nums[right] == target && result[1] == -1 ){
                result[1] = right;
                rightFlag=true;
            }
            if (!rightFlag){
                right--;
            }
        }
        return result;
    }
}
