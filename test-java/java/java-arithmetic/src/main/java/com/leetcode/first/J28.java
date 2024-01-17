package com.leetcode.first;

public class J28 {

    public static void main(String[] args) {

        System.out.println(new J28().strStr("abc","c"));
    }

    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)){
            return 0;
        }
        for (int i=0;i<haystack.length();i++){
            if (haystack.startsWith(needle, i)){
                return i;
            }
        }
        return -1;
    }
}
