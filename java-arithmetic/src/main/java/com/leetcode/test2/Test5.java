package com.leetcode.test2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author guozhenhua
 * @date 2020/07/04
 */
public class Test5 {


    public static List<String> allDataList =new ArrayList<>();
    public static Queue<Integer> subQueue=new ArrayDeque<>();

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String trim = br.readLine().trim();//输入一串计算公式
        add(trim);
        System.out.println(sub());
    }

    /**
     * 先计算所有的+法
     * @param enterNum
     */

    public static void add(String enterNum){
        String sb= new String();
        for (int i=0;i<enterNum.length();i++){
            if ('-'==enterNum.charAt(i)||'+'==enterNum.charAt(i)){
                allDataList.add(sb);
                allDataList.add(String.valueOf(enterNum.charAt(i)));
                sb="";
            }else{
                sb=sb+enterNum.charAt(i);
                if (i==enterNum.length()-1){
                    allDataList.add(sb);
                }
                continue;
            }
        }
        if (allDataList.size()==1){
            subQueue.add(Integer.valueOf(allDataList.get(0)));
            return;
        }
        //计算allQueue 中所有的加法运算，将减法运算的数字都放到subQueue中去，
        Integer first=Integer.valueOf(allDataList.get(0));
        for (int i=1;i<allDataList.size()-1;i++){
            Integer result=0;
            if ("-".equals(allDataList.get(i))){
                subQueue.add(Integer.valueOf(first));
                first=Integer.valueOf(allDataList.get(i+1));
                if (i==allDataList.size()-2){
                    subQueue.add(first);
                }
            }
            if ("+".equals(allDataList.get(i))){
                result=Integer.valueOf(first)+Integer.valueOf(allDataList.get(i+1));
                first=result;
                if (i==allDataList.size()-2){
                    subQueue.add(result);
                }
            }

        }
    }

    /**
     * 计算减法队列中的数据
     * @return
     */
    private static int sub(){
        if (subQueue.isEmpty()){
            return 0;
        }
        int result=Integer.valueOf(subQueue.poll());
        while (!subQueue.isEmpty()){
            result =result-subQueue.poll();
        }
        return result;
    }
}
