package com.leetcode.dynamic;

/**
 * Created by guozhenhua
 * date 2020/5/22.
 */
public class Test1 {

    public static int add(int n){
        if(n==2||n==1){
            return 1;
        }
        return add(n-2)+add(n-1);
    }

    //1、1、2、3、5、8、13、21、34
    public static void main(String[] args) {
//        int sum = 0;
//        for(int i = 1; i <= 3; i++){
//            sum += add(i);
//        }
//        System.out.println(sum);

        System.out.println(add2(10));

    }

    public static int add2(int n){
        if (n == 2 || n == 1)
            return 1;
        int prev = 1, curr = 1;

        for (int i=3;i<=n;i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }




}
