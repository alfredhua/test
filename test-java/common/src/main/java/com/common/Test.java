package com.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guozhenhua
 * @date 2021/07/12
 */
public class Test {

  public static void main(String[] args) {
    d      String a="123456";
    String b="15";
    char[] aChars= a.toCharArray();
    char[] bChars=a.toCharArray();
    //专门存放每一步的乘法的集合
    List<String> list=new ArrayList();
    //倒序遍历 a
    for(int i=aChars.length-1; i>=0;i-- ){

      String c=""; //用于存放每一步相乘的结果
                   //倒序遍历 b
      int k=0;
      for(int j=bChars.length-1; j>=0;j--){
        //获取A的最后一位
        int num= Integer.valueOf(aChars[i]);
        //获取b的最后一位
        int twoNum= Integer.valueOf(aChars[j]);
        int result= num * twoNum +k ; //后面的一步+k
        k= result / 10;  //当前的结果，用于下一次的相加
        int  f= result % 10;  //当前的结果
        c=c+String.valueOf(f);
      }
      //a是倒序，需要改变存放进去
      System.out.println(c);
      list.add(c);
    }
    //遍历循环list，将list中的每个String的数字相加
  }
}
