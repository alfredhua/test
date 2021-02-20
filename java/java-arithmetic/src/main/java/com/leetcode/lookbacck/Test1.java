package com.leetcode.lookbacck;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by guozhenhua
 * date 2020/5/22.
 * 从n个不同元素中任取m（m≤n）个元素，按照一定的顺序排列起来，
 * 叫做从n个不同元素中取出m个元素的一个排列。当m=n时所有的排列情况叫全排列。
 */
public class Test1 {

    static List<LinkedList<Integer>> res = new LinkedList<>();
    public static  List<LinkedList<Integer>> lookBack(Integer[] nums){
        LinkedList<Integer> list=new LinkedList<>();
        backtrack(nums,list);
        return res;
    }

    public static void backtrack(Integer[] nums,LinkedList<Integer> list){
        if (list.size() == nums.length) {
            res.add(new LinkedList(list));
            return;
        }

        for (int i=0;i<nums.length;i++){
            if (list.contains(nums[i])){
                continue;
            }
            int a= nums[i];
            list.add(a);

            backtrack(nums, list);

            list.removeLast();
        }
    }

    public static void main(String[] args) {
        Integer[] a= new Integer[]{1,2,3};
        lookBack(a);
        for (LinkedList<Integer> linkedList:res) {
            linkedList.stream().forEach(i->{
                System.out.print(i+",");
            });
            System.out.println();

        }
    }
}
