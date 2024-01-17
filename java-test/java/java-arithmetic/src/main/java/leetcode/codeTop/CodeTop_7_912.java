package leetcode.codeTop;

public class CodeTop_7_912 {

    public static void main(String[] args) {
        int[] ints = new CodeTop_7_912().sortArray(new int[]{4, 6, 8, 3, 5, 9});
        System.out.println();

    }

    public int[] sortArray(int[] nums) {
        return quickSort(nums,0,nums.length-1);
    }


    public int[] quickSort(int[] nums,int left, int right){
        if (left <  right){
            int index = getPartion(nums,left,right);
            quickSort(nums,left,index-1);
            quickSort(nums,index+1,right);
        }
        return nums;
    }

    public int getPartion(int[] nums,int left,int right){
        //以 x 为基准，小的数左边，大的数右边
        int index = left+1;
        for (int i=left+1;i<=right;i++ ){
            if (nums[i] > nums[left]){
                swap(nums,index,i);
                index++;
            }
        }
        swap(nums,left,index-1);
        return index-1;
    }

    public void  swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



}
