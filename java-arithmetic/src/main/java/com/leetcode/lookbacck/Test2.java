package com.leetcode.lookbacck;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by guozhenhua
 * date 2020/5/22.
 */
public class Test2 {

    static  List<LinkedList<Integer>> res=new ArrayList<>();

    private static void back(Integer[] nums,LinkedList<Integer> a){
        if (a.size()==nums.length){
            res.add(new LinkedList<>(a));
            return;
        }
       // num3 ---- > 0 1,2，3层，第三层要去除：a.removeLast();
        for (Integer num : nums) {
            //第一层
            if (a.contains(num)) {
                continue;
            }
            a.add(num);
            //第二层，第三层，
            back(nums, a);
            //最后一次的时候要全都删除
            a.removeLast();
        }
    }

    public static void main(String[] args) {
        Integer[] nums=new Integer[]{1,2,3};
        back(nums,new LinkedList<>());

        for (LinkedList<Integer> linked:res) {
            linked.stream().forEach(i->{
                System.out.print(i+",");
            });
            System.out.println();
        }
    }
}
