//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1401 👎 0

  
package leetcode.editor.cn;

public class FindFirstAndLastPositionOfElementInSortedArray_34{

   public static void main(String[] args) {
       Solution solution = new FindFirstAndLastPositionOfElementInSortedArray_34().new Solution();
   }
   
   //leetcode submit region begin(Prohibit modification and deletion)
   class Solution {
       int[] nums;
       int n;
       int target;
       public int[] searchRange(int[] nums, int target) {
           int[] ans=new int[]{-1,-1};
           if(nums==null||nums.length==0)
               return ans;

           this.nums=nums;
           this.target=target;
           n=nums.length;

           ans[0]=findFirst();
           if(ans[0]==-1)
               return ans;
           ans[1]=findLast();
           return ans;
       }
       //寻找左边界
       private int findFirst(){
           int left=0,right=n-1;
           while(left<right){
               int mid=(left+right)/2;
               if(target==nums[mid])
                   right=mid;
               else if(target<nums[mid])
                   right=mid-1;
               else
                   left=mid+1;
           }
           return nums[left]==target?left:-1;
       }
       //寻找右边界
       private int findLast(){
           int left=0,right=n-1;
           while(left<right){
               int mid=(left+right+1)/2;
               if(target==nums[mid])
                   left=mid;
               else if(target<nums[mid])
                   right=mid-1;
               else
                   left=mid+1;
           }
           return nums[left]==target?left:-1;

       }
   }

//leetcode submit region end(Prohibit modification and deletion)

   
}