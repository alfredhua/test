package com.leetcode.window;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by guozhenhua
 * date 2020/5/22.
 *
 * S="ADOBECODEBANC"  T="ABC"
 *
 * 输出：BANC
 */
public class Test1 {

    static  Map<String,Integer> map=new HashMap<>();

    public static void main(String[] args) {
        window("ADOABCECODEBANC".toCharArray(), "ABC".toCharArray());
    }

    public static void window(char[] s,char[] t){
        int right=0;
        Queue<String> queue=new LinkedBlockingDeque();
        for (int i=0;i<t.length;i++){
            queue.add(String.valueOf(s[i]));
        }

        while (right<s.length){
            //需要右面滑动，窗口变大
            if(contains(t,queue)&&queue.size()>t.length){
                //全部包含了
                queue.poll();
            }else{
                //不包含
                right++;
                if (right>s.length-1){
                    break;
                }
                queue.add(String.valueOf(s[right]));
            }
        }
    }


    private static boolean contains(char[] t,Queue<String> queue){
        for (int j=0;j<t.length;j++){
            if (!queue.contains(String.valueOf(t[j]))){
                return false;
            }
        }
        System.out.println(queue.toString());
        map.put(queue.toString(),queue.size());
        return true;
    }
}
