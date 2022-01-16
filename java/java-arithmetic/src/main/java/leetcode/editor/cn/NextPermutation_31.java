//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 👍 1486 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;

public class NextPermutation_31{

   public static void main(String[] args) {
       Solution solution = new NextPermutation_31().new Solution();
       int[] ints = {1,3,2};
       solution.nextPermutation(ints);
       System.out.println(ints);

   }

    /**
     *  从右 - 左 比较，记录最小值，
     *  与 正序互换
     */
   //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            int R = n - 1;
            int L = R - 1;
            while(L >= 0){
                if(nums[R] > nums[L]){
                    for(int i=n-1; i>=R; i--){
                        if(nums[i] > nums[L]){
                            swap(nums, i, L);
                            break;
                        }
                    }
                    int i = n - 1;
                    int j = R;
                    while(j < i){
                        swap(nums, i, j);
                        i--;
                        j++;
                    }
                    return;
                }else{
                    R--;
                    L--;
                }
            }
            Arrays.sort(nums);
            return;

        }
        public void swap(int[] nums, int a, int b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

   
}