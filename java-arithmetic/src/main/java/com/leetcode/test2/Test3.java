package com.leetcode.test2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author guozhenhua
 * @date 2020/07/04
 *
 * S: 前进一步
 * R: 向右转
 * L: 向左转
 *
 */
public class Test3 {

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine().trim());  //输入第一行数据
        if (n<1||n>50){
            System.out.println("no");
        }
        //输入下面每行的指令
        String []cmd = new String[n];
        for (int i=0;i<n;i++){
             cmd[i] = br.readLine().trim();
        }
        System.out.println(getExit(cmd));
    }
    /**
     * 当前位置是0,0  角度也是0，
     * 记录旋转的角度，如果是360度的倍数，则是在转圈圈
     * 记录位置，位置发生了变化则没有在原地
     * @param cmd
     * @return
     */
    public static String getExit(String[] cmd){
        int angle=0, x0=0, y0=0, x=x0, y=y0; //方向（角度），距离
        //遍历每一行的命令
        for (String s : cmd) {
            for (char c : s.toCharArray()) {
                if (c=='L') {
                    angle -= 90; //以左转为-90度
                } else if (c=='R') {
                    angle += 90; //右转为+90度
                } else if (c=='S') { //以北为0度
                    int m = angle%360;
                    if (m==0) y++; //往北走
                    else if (m==-90 || m==270) x--; //往西走
                    else if (m==180 || m== -180) y--; //往南走
                    else if (m==-270 || m==90) x++; //往东走
                }
            }
        }
        if (angle%360==0 && (x!=x0 || y!=y0)) { //如果方向不变位置改变
            return "yes";
        } else {
            return "no";
        }
    }
}
