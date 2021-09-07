package com.leetcode.first;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class J20 {
    public static void main(String[] args) {
        String s="([()()])";
//        System.out.println(s.substring(7,1));
        boolean vaild = new J20().isVaild(s);
        System.out.println(vaild);

    }


    public boolean isVaild(String s){
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)){
                if (stack.isEmpty()||stack.peek()!=pairs.get(ch)){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
       return stack.isEmpty();
    }
}
