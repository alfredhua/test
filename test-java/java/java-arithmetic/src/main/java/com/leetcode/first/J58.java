package com.leetcode.first;

public class J58 {


    public static void main(String[] args) {
//        System.out.println(new J58().lengthOfLastWord("   fly me   to   the moon  "));
//        System.out.println(new J58().lengthOfLastWord(" a"));
//        System.out.println(new J58().lengthOfLastWord("hello world"));
        System.out.println(new J58().lengthOfLastWord("a"));

    }

    public int lengthOfLastWord(String s) {
       int end =s.length()-1;
       while (end>=0 && s.charAt(end)==' '){
           end--;
       }
       if ( end<0){
           return 0;
       }
       int start=end;
       while (start>=0 && s.charAt(start)!=' '){
           start--;
       }
       return end -start;
    }

}
