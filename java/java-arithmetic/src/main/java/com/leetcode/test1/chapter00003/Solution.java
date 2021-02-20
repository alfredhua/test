package com.leetcode.test1.chapter00003;

import java.util.HashSet;
import java.util.Set;

/**
 *
 *    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *      "abcabcbb"  3  abc
 *      bbbbb   1  b
 */
class Solution {

    public int lengthOfLongestSubstring(String s) {
        int result =0,start=0,end=0;
        Set<Character> set=new HashSet<>();
        while(start<s.length()&& end<s.length()){
            if (!set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                end++;
                result=Math.max(result,end-start);
            }else{
                set.remove(s.charAt(start));
                start++;
            }
        }
        return result;
    }



    public static void main(String[] args) {
        //"abcabcbb"
        int a = new Solution().lengthOfLongestSubstring("abcabcbb");
        System.out.println(a+"");
    }
}