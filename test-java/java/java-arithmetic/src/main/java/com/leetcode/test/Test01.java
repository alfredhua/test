package com.leetcode.test;

/**
 * @author guozhenhua
 * @date 2021/07/06
 */
public class Test01 {
//    1、1、2、3、5、8、13、21、34

    public static void main(String[] args){
        System.out.println(get(6));
    }


    public static int get(Integer num){
        if (num == 1|| num ==2 ){
            return 1;
        }
        return get(num-1)+get(num-2);
    }

//    public int getNum(Integer num){
//
//    }


}
