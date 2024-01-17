package com.leetcode.first;

import java.util.ArrayList;
import java.util.List;

public class J09 {

    public static void main(String[] args) {
        String[] st={"flower","flow","flight"};
        String longPrex = new J09().getLongPrex(st);
        System.out.printf(longPrex);

    }


    public String getLongPrex(String[] list){
        if ( list==null||list.length==0){
            return "";
        }
        String prex =list[0];
        for (int i = 1; i < list.length; i++) {
            prex = getPrex(prex,list[i]);
        }

        return prex;
    }

    public String getPrex(String str1,String str2){
        int index=0;
        int minLength= Math.min(str1.length(),str2.length());
        System.out.println(str1.charAt(index)+"-------------"+str2.charAt(index));
        while (index<minLength && str1.charAt(index) == str2.charAt(index)){
            index++;
        }
        return str1.substring(0,index);
    }
}
