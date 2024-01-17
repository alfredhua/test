package com.codeTop;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public static void main(String[] args) {
        List<Integer> list = new SpiralOrder().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(list);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        // 四个方向，右，下，左，上
//        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0;
        int col =0;
        int tr = matrix.length;
        int tc = matrix[0].length;
        int total = tc * tr;
        int index = 0;
        boolean[][] visited = new boolean[tr][tc];
        for (int i =0;i<total;i++){
            result.add(matrix[row][col]);
            // 终止，当转了一圈的时候，这个就会终止
            visited[row][col] = true;
            // 四个边界
            int nextRow = row + directions[index][0], nextColumn = col + directions[index][1];
            if (nextRow >= tr || nextRow<0 || nextColumn>=tc || nextColumn<0 || visited[nextRow][nextColumn]){
                index = (index+1) %4;
            }
            row = row + directions[index][0];
            col = col + directions[index][1];
        }
        return result;
    }
}
