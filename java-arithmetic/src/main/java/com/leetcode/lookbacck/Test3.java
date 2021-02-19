package com.leetcode.lookbacck;

/**
 * Created by guozhenhua
 * date 2020/5/22.
 * 这个问题很经典了，简单解释一下:给你一个 N×N 的棋盘，让你放置 N 个 皇后，使得它们不能互相攻击。
 * PS:皇后可以攻击同一行、同一列、左上左下右上右下四个方向的任意单 位。
 * if 满足结束条件:
 *  result.add(路径) return
 *
 * for 选择 in 选择列表:
 *      做选择
 * backtrack(...)
 *      撤销选择
 */
public class Test3 {

    private static int count=0;            //结果计数器


    public static void main(String[] args) {
        short chess[][]=new short[8][8];
        putQueenAtRow(chess,0,8);
    }

    private static void putQueenAtRow(short[][] chess, int row,int N) {
        if(row==N){
            count++;
            System.out.println("第 "+ count +" 种解：");
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    System.out.print(chess[i][j]+" ");
                }
                System.out.println();
            }
            return;
        }

        short[][] chessTemp=chess.clone();
        /**
         * 向这一行的每一个位置尝试排放皇后
         * 然后检测状态，如果安全则继续执行递归函数摆放下一行皇后
         */
        for(int i=0;i<N;i++){
            //摆放这一行的皇后，之前要清掉所有这一行摆放的记录，防止污染棋盘
            for(int j=0;j<N;j++)
                chessTemp[row][j]=0;
            chessTemp[row][i]=1;

            if( isSafety( chessTemp,row,i,N) ){
                putQueenAtRow(chessTemp,row+1,N);
            }
        }
    }

    private static boolean isSafety(short[][] chess,int row,int col,int N) {
        //判断中上、左上、右上是否安全
        int step=1;
        while(row-step>=0){
            if(chess[row-step][col]==1)                //中上
                return false;
            if(col-step>=0 && chess[row-step][col-step]==1)        //左上
                return false;
            if(col+step<N && chess[row-step][col+step]==1)        //右上
                return false;

            step++;
        }
        return true;
    }

}
