package leetcode.codeTop;

public class CodeTop_12_33 {
    public static void main(String[] args) {
        int[] a ={4,5,6,7,0,1,2};
        int search = new CodeTop_12_33().search(a, 0);
        System.out.println(search);
    }
    public int search(int[] nums, int target) {
        int size = nums.length;
        int left = 0,right = size -1;
        if (size<1){
            return -1;
        }
        while (left<right){
            int mid = left + (right-left)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[0] <= nums[mid]){
                //左半部分
                if (nums[0]<=target && target<nums[mid]){
                    left = mid -1;
                }else{
                    right = mid +1;
                }
            }else{
                //右半部分
                if (nums[mid]<target && target<=nums[size-1]){
                    left = mid + 1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }


}
