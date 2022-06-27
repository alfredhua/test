package leetcode.codeTop;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *  
 *
 */
public class CodeTop_4_215 {

    public static void main(String[] args) {
        int[] a=new int[]{3, 2, 3, 1, 6, 6, 5, 5, 4};
        int kthLargest = new CodeTop_4_215().findKthLargest(a, 4);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums.length<2 && k==1){
            return nums[0];
        }
        return quickSort(nums,0,nums.length-1,k);
    }

    /**
     * 快速排序
     * @param nums
     * @param left
     * @param right
     * @param k
     * @return
     */
    public int quickSort(int[] nums,int left,int right,int k){
        int  s= nums.length -k;
        int index = getPartition(nums, left, right);
        if (s == index){
            return nums[s];
        }
        return s > index ? quickSort(nums, index + 1, right, k): quickSort(nums, left, index - 1, k);
    }

    /**
     * 找到一个基准位置，比该数小的放在前面，比该数大的放在后面
     * @param nums
     * @return
     */
    public int getPartition(int[] arr,int left,int right){
        int index = left + 1;
        //最左边left为基准值
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < arr[left]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, left, index - 1);
        return index - 1;
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
