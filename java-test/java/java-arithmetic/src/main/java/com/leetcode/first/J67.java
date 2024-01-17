package com.leetcode.first;

public class J67 {

    public static void main(String[] args) {
        System.out.println(new J67().addBinary("11","1"));

    }

    public String addBinary(String a, String b) {
        int iA = Integer.parseInt(a, 2);
        int iB = Integer.parseInt(b, 2);
        return  Integer.toBinaryString(iA+iB);
    }

}
