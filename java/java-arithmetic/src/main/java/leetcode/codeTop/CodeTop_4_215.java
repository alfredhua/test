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
        int kthLargest = new CodeTop_4_215().findKthLargest2(a, 4);
        System.out.println(kthLargest);
    }


    private int findKthLargest2(int[] nums,int k){
        if (nums.length<2 && k == 1 ){
            return nums[0];
        }
        return quickSort2(nums,0,nums.length-1,k);
    }
    // 升序，正向第 k个,0,1,2,3,4,5
    private int quickSort2(int[] nums, int left, int right , int k){
        int res = nums.length -k;
        //1.找的基准位置
        int index = getPartition2(nums,left,right);
        if ( index  == res){
            return nums[res];
        }
        // 左边进行快排，右边进行快排。
        if ( res > index){
            //右边快排
            return quickSort2(nums,index+1,right,k);
        }
        //左边快排
        return quickSort2(nums,left,index-1,k);

    }

    /**
     * 获取基准位置,左边的数 都是比基准小，右边的数都比基准大
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int getPartition2(int[] arr, int left, int right){
        //最左边的数为基数
        int index = left+1;
        for (int i=left+1;i<=right;i++){
            if (arr[i] < arr[left]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr,left,index-1);
        return index-1;
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
