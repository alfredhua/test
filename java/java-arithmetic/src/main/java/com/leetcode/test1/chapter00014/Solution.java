package com.leetcode.test1.chapter00014;

/**
 * @author guozhenhua
 * @date 2020/03/24
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            while (j<ans.length() && j < strs[i].length()){
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
                j++;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }



    public String longestCommonPrefix2(String[] strs) {
        int i=1;
        String a="";
        if (strs==null||strs.length==0){
            return "";
        }
        if (strs.length==1){
            return strs[0];
        }
        if ("".equals(strs[0])){
            return "";
        }
        loop: while (i<=strs[0].length()){
            a=strs[0].substring(0, i);
            for (int j = 1; j < strs.length; j++) {
                if ("".equals(strs[j])){
                    a="";
                    break loop;
                }
                if (strs[j].length()<i){
                    a= strs[j];
                    break;
                }
                if (!a.equals(strs[j].substring(0,i))){
                    a=a.substring(0,a.length()-1);
                    break loop;
                }

            }
            i++;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        String[] ar=new String[]{"flower","flow","flight"};
        String[] b=new String[]{"dog","racecar","car"};
        String[] c=new String[]{"c","c"};
        String[] d=new String[]{"cc","c"};
        String[] e=new String[]{"abab","aba",""};
        System.out.println(solution.longestCommonPrefix(e));
    }
}
