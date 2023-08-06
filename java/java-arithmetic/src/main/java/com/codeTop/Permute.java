package com.codeTop;

import lombok.val;

import java.util.ArrayList;
import java.util.List;

public class Permute {


    public static void main(String[] args) {
        List<List<Integer>> permute = new Permute().permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int[] t = new int[nums.length];
        back(nums,result,temp,t);
        return result;
    }

    public void back(int[] nums,List<List<Integer>> result,List<Integer> temp, int[] t){
        //  终止条件
        if (temp.size()==nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i =0;i<nums.length;i++){
            if (t[i] ==1 ){
                continue;
            }
            t[i] = 1;
            temp.add(nums[i]);
            back(nums,result,temp,t);
            t[i] =0;
            temp.remove(temp.size()-1);
        }
    }
}
