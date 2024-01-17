package leetcode.offer2;

public class OfferFindRepeatNumber_03 {

    public static void main(String[] args) {

        OfferFindRepeatNumber_03 offerFindRepeatNumber03 = new OfferFindRepeatNumber_03();
        int repeatNumber = offerFindRepeatNumber03.findRepeatNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 7, 8, 8, 9});
        System.out.printf(repeatNumber+"");
    }

    public int findRepeatNumber(int[] nums) {
        for (int i =0;i<nums.length-1;i++){
            for (int j =i+1;j<nums.length;j++){
                if (nums[i] == nums[j]){
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
