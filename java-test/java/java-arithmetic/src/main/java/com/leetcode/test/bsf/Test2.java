package com.leetcode.test.bsf;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by guozhenhua
 * date 2020/5/25.
 */
public class Test2 {



    private static String plusUp(String s,int j){
        char[] chars = s.toCharArray();
        if (chars[j]=='9'){
            chars[j]='0';
        }else{
            chars[j] += 1;
        }
        return new String(chars);
    }


    private static String plusDown(String s,int j){
        char[] chars = s.toCharArray();
        if (chars[j]=='0'){
            chars[j]='9';
        }else{
            chars[j] -= 1;
        }
        return new String(chars);
    }

    static  int bfs(String[] deadends,String target) {

        Set<String> deads = new HashSet<>();
        for (String s : deadends) deads.add(s);

        int step = 0;
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向周围扩散 */
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                if (deads.contains(cur))
                    continue;
                if (cur.equals(target))
                    return step;
                /* 判断是否到达终点 */
                System.out.println(cur);
                /* 将一个节点的相邻节点加入队列 */
                for (int j = 0; j < 4; j++) {
                    q.offer(plusUp(cur, j));
                    q.offer(plusDown(cur, j));
                }
            }
            /* 在这里增加步数 */
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(bfs(new String[]{"8888"},"0009"));
    }

}
