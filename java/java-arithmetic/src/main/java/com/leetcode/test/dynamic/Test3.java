package com.leetcode.test.dynamic;

/**
 * Created by guozhenhua
 * date 2020/5/26.
 * 背包问题
 * 背包总容量为V = 12
 * 物品的容量数组为 w = [4, 6, 2, 2, 5, 1]
 * 价值数组为 c = [8, 10, 6, 3, 7, 2]
 */
public class Test3 {

    static int totalValue=12;

    static int back(int[] weight, int[] value){
        int[][] b = new int[weight.length][totalValue];
        for (int i=1;i<weight.length;i++){ //枚举背包容量
            for (int j=1;j<=totalValue;j++){  //总重量12
                if (weight[i]>j) {
                    b[i][j]=b[i-1][j];
                }else{
                    int value1 = b[i][j - weight[i]] + value[i]; // 拿第i件物品
                    int value2 = b[i ][j]; // 不拿第i件物品
                    b[i][j] = Math.max(value1, value2);
                }
            }

        }

        return b[weight.length-1][totalValue-1] ;
    }

    public static void main(String[] args) {
//        int[] w = { 0, 2, 3, 4, 5, 9 };
//        int[] v = { 0, 3, 4, 5, 8, 10 };
//        int N = 6, W = 21;
//        int[][] b = new int[N][W];
//        for (int k = 1; k < N; k++) {  //6件物品
//            for (int c = 1; c < W; c++) { //总重量
//                if (w[k] > c) {
//                    b[k][c] = b[k - 1][c];
//                } else {
//                    int value1 = b[k - 1][c - w[k]] + v[k]; // 拿第k件物品
//                    int value2 = b[k - 1][c]; // 不拿第k件物品
//                    b[k][c] = Math.max(value1, value2);
//                }
//            }
//        }
//        System.out.println(b[5][20]);

        System.out.println(back(new int[]{0,4, 6, 2, 2, 5, 1},new int[]{0,8, 10, 6, 3, 7, 2}));
    }
}
