package com.common;

/**
 * @author guozhenhua
 * @date 2021/07/12
 */
public class Test3 {

    //1,1,2,3,5,8,13 求第15个数

    public static void main(String[] args) {
        int num= 7 ;
        int  first=1;
        int  second=1;
        for (int i=1;i<num;i++){
            int temp= first + second;  //2 第三个数 ---第而get数
            first  =second;
            second = temp;
        }
        System.out.println(first);
    }




}
