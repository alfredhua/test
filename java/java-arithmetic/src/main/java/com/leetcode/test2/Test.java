package com.leetcode.test2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author guozhenhua
 * @date 2020/07/04
 */
public class Test {

    public static void main(String[] args)throws Exception  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        System.out.println(calculatePowerForTwo(n));

    }

    public static int calculatePowerForTwo(int num){
        if (num==1){
            return 1;
        }
        //除2是否有余数，如果有，则一定不是
        if (num%2==0){
            //不断的除以二，用结果一直count=1的时候
            int count= num/2;
            if (count>0&&count!=1){
                count=calculatePowerForTwo(count);
            }
            return count;
        }else{
            return 0;
        }
    }

}
