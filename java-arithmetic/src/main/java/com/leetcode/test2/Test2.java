package com.leetcode.test2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author guozhenhua
 * @date 2020/07/04
 */
public class Test2 {


    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String trim = br.readLine().trim();
        System.out.println(calculateCount(trim));
    }

    private static int calculateCount(String num){
        int count=0;
        int [] init=new int[num.length()];
        for (int i=0;i<init.length;i++){
            if (init[i]==Integer.valueOf(num.substring(i,i+1))){
                //相等进入下次循环
                continue;
            }else{
                //不相等，需要将init后的所有数字进行变化，count+1
                count++;
                for (int j=i;j<init.length;j++){
                    if (init[j]==0){
                        init[j]=1;
                    }else {
                        init[j]=0;
                    }
                }
            }
        }
        return count;
    }
}
