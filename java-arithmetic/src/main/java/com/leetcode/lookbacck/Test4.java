package com.leetcode.lookbacck;

/**
 * Created by guozhenhua
 * date 2020/5/22.
 */
public class Test4 {

    static int count=0;

    public static void putQueenAtRow(int currentRow,int n,short[][] chess){
        if (currentRow==n){
            count++;
            return;
        }
        short[][] chessTemp=chess.clone();
        for(int col=0;col<n;col++){
            for(int j=0;j<n;j++){
                //摆放这一行的皇后，之前要清掉所有这一行摆放的记录，防止污染棋盘
                chessTemp[currentRow][j]=0;
            }
            chessTemp[currentRow][col]=1;
            if( isSafe( currentRow,col,chessTemp) ){
                putQueenAtRow(currentRow+1,n,chessTemp);
            }
        }

    }


    static boolean isSafe(int row,int col,short[][] chess){
        int step=1;
        //第n行
        while (row-step>=0){
            //中上
            if(chess[row-step][col]==1){
                return false;
            }
            if(col-step>=0 &&chess[row-step][col-step]==1){ //左上
                return false;
            }
            if(col+step<chess.length && chess[row-step][col+step]==1){ //右上
                return false;
            }
            step++;
        }
        return true;
    }

    public static void main(String[] args) {
        int n=8;
        putQueenAtRow(0,n,new short[n][n]);
        System.out.println("总共有:"+count+"种方法");
    }

}
