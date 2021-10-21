package com.leetcode.test.test2;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        String[] cmd;
            System.out.println("输入");
            cmd = getUserInput();
            System.out.printf("输出\n%s\n", checkCmd(cmd));
    }

    public static String[] getUserInput() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while (true) {
            try {
                //System.out.println("请输入1-50之间的数字：");
                n = Integer.valueOf(sc.nextLine());
                if (n>0&&n<51) break;
            } catch (Exception e) {
                n = 1; //default
                break;
            }
            //System.out.println("输入错误，请重输。");
        }
        String []cmd = new String[n];
        for (int i=0; i<n; i++) {
            while(true) {
                try {
                    //System.out.printf("请输入第%d行指令（指令必须有[LRS]中字母构成其总长度不超过50）：");
                    cmd[i] = sc.nextLine();
                    if (cmd[i].matches("[LRS]{1,50}")) break;
                } catch (Exception e) {
                    cmd[i] = "S"; //default
                    break;
                }
                //System.out.println("输入错误，请重输。");
            }
        }
        return cmd;
    }

    public static String checkCmd(String[] cmd) {
        int angle=0, x0=0, y0=0, x=x0, y=y0; //方向（角度），距离
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
//
//    public static String[] getRandomCmd(int uc) { //测试数据
//        if (uc==0) return new String[] {"LLLLS"};
//        else if (uc==1) return new String[] {"SSSS", "R"};
//        char[] chs = {'L', 'R', 'S'};
//        Random rad = new Random();
//        if (uc>49) uc=49;
//        int n = rad.nextInt(uc+1) + 1;
//        String[] cmd = new String[n];
//        for (int i=0; i<n; i++) {
//            int len = rad.nextInt(50) + 1;
//            StringBuilder buf = new StringBuilder();
//            for (int j=0; j<len; j++) {
//                buf.append(chs[rad.nextInt(3)]);
//            }
//            cmd[i] = buf.toString();
//        }
//        return cmd;
//    }
}