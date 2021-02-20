package com.leetcode;

/**
 *
 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 返回被除数 dividend 除以除数 divisor 得到的商。
 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

 示例 1:

 输入: dividend = 10, divisor = 3
 输出: 3
 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 示例 2:

 输入: dividend = 7, divisor = -3
 输出: -2
 解释: 7/-3 = truncate(-2.33333..) = -2

 首先11比3大，结果至少是1， 然后我让3翻倍，就是6，发现11比3翻倍后还要大，那么结果就至少是2了，
 那我让这个6再翻倍，得12，11不比12大，吓死我了，差点让就让刚才的最小解2也翻倍得到4了。
 但是我知道最终结果肯定在2和4之间。也就是说2再加上某个数，这个数是多少呢？我让11减去刚才最后一次的结果6，
 剩下5，我们计算5是3的几倍，也就是除法，看，递归出现了。说得很乱，不严谨，大家看个大概，然后自己在纸上画一画，或者直接看我代码就好啦！
 */
public class L29 {

    public static void main(String[] args) {
        L29 l29 = new L29();
        System.out.println(l29.truncate(10,4));
//        System.out.println(3<<2);
    }


    private Integer truncate(Integer dividend, Integer divisor){
        if (dividend==0||divisor==0){
            return 0;
        }
        boolean flag=false;
        if ((dividend<0 && divisor>0) || (dividend>0 && divisor<0) ){
            flag=true;
        }
        if (dividend<0){
            dividend= - dividend;
        }
        if (divisor<0){
            divisor= - divisor;
        }

        while (true){

        }
//        return 0;
    }


    private Integer sub(){
        return null;
    }


}
