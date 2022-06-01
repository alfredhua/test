package leetcode.offer2;

public class OfferFindMin_153 {

    public static void main(String[] args) {
        int min = new OfferFindMin_153().findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
        System.out.println(min);
    }


    public int findMin(int[] nums) {
        int left = 0 , right = nums.length - 1;

        while (left< right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]){
                right = mid;
            }else{
                left = mid +1;
            }

        }

        return nums[left];
    }

}
