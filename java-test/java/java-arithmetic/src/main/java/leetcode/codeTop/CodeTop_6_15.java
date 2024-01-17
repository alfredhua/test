package leetcode.codeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeTop_6_15 {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List result =new ArrayList();
        for (int i =0;i<nums.length;i++){
            if (nums[i] > 0){
                break;
            }
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i+1,r = nums.length-1;
            while (l < r){
                int res = nums[i] + nums[l] + nums[r];
                if (res ==0 ){
                    result.add(Arrays.asList(nums[i],nums[l],nums[r]));
//                    while (l<r && nums[l]==nums[l+1]){
//                        l++;
//                    }
//                    while (l<r && nums[r]==nums[r-1]){
//                        r--;
//                    }
                    l++;
                    r--;
                }else if (res<0){
                    l++;
                }else {
                    r--;
                }
            }

        }
        return result;
    }

}
