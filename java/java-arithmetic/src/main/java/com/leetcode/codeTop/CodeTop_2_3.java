package com.leetcode.codeTop;
/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author guozhenhua
 * @date 2022/6/14
 */
public class CodeTop_2_3 {

    public static void main(String[] args) {
        int abcabcbb = new CodeTop_2_3().lengthOfLongestSubstring("abcabcbb");
        System.out.println(abcabcbb);
        int bbbbb = new CodeTop_2_3().lengthOfLongestSubstring("bbbbb");
        System.out.println(bbbbb);
        int pwwkew = new CodeTop_2_3().lengthOfLongestSubstring("pwwkew");
        System.out.println(pwwkew);

        int a = new CodeTop_2_3().lengthOfLongestSubstring("au");
        System.out.println(a);

        int aa = new CodeTop_2_3().lengthOfLongestSubstring("aa");
        System.out.println(aa);
    }


    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int k =0;
        int result = 0;
        if (s.length()<2){
            return  s.length();
        }
        for (int i=0;i<s.length();i++){
            if (map.containsKey(s.charAt(i))){
                k = map.get(s.charAt(i))+1;
            }
            map.put(s.charAt(i),i);
            result = Math.max(result,i-k+1);
        }
        return result;
    }

}
