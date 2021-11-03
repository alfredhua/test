package com.leetcode.of;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 */
public class J02 {

    public int fib(int n) {
        if (n == 0 ){
            return 0;
        }
        if (n==1 || n==2){
            return 1;
        }
        return fib(n-2) + fib(n-1);
    }

    public int fib2(int n) {
        if (n == 0 ){
            return 0;
        }
        int count=0;
        int first=0;
        int second=1;
        while (count<n){
            int num=first;
            first=second;
            second=num+second;
            count++;
        }
        return first;
    }

    public static void main(String[] args) {
        System.out.println(new J02().fib(46));
        System.out.println(new J02().fib2(46));

    }
    // 134903163

}
