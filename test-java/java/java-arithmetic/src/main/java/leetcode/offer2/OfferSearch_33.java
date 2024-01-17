package leetcode.offer2;

public class OfferSearch_33 {

    public static void main(String[] args) {
        int search = new OfferSearch_33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while ( left <= right ){
            int mid = left+(right - left) /2;
            if (nums[mid] ==  target){
                return mid;
            }
            if (nums[0] <=  nums[mid]){
                // 左边有序
                if (nums[0] <=target && target <= nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                // 右边有序
                if (nums[mid]<target && target<=nums[nums.length-1]){
                    left=mid+1;
                }else {
                    right =mid -1;
                }
            }
        }
        return -1;
    }


}
