//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 双指针 排序 👍 1075 👎 0

  
package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class FourSum_18{

   public static void main(String[] args) {
       Solution solution = new FourSum_18().new Solution();
       System.out.println(solution.fourSum(new int[]{1,0,-1,0,-2,2},0));
       System.out.println(solution.fourSum(new int[]{2,2,2,2,2},8));
   }
   
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> list=new HashSet<>();
        for (int i=0;i<nums.length-2;i++){
            for (int j=i+1;j<nums.length-1;j++){
                int start=j+1;
                int end = nums.length-1;
                while (start<end){
                    if ( nums[i]+nums[j]+nums[start]+nums[end]==target){
                        List<Integer> subList=new ArrayList<>();
                        subList.add(nums[i]);
                        subList.add(nums[j]);
                        subList.add(nums[start]);
                        subList.add(nums[end]);
                        list.add(subList);
                        break;
                    }
                    if (nums[i]+nums[j]+nums[start]+nums[end]<target){
                        start++;
                    }
                    if (nums[i]+nums[j]+nums[start]+nums[end]>target){
                        end--;
                    }
                }
            }
        }
        return list.stream().collect(Collectors.toList());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

   
}