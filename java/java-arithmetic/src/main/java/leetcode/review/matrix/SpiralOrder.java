package leetcode.review.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int total = matrix.length * matrix[0].length;
        // 遍历
        int row = 0, column = 0;
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<Integer> result = new ArrayList<>();
        int directIndex = 0;
        for (int i = 0; i < total; i++) {
            result.add(matrix[row][column]);
            visit[row][column] = true;
            int[] direct = directions[directIndex];
            int nextRow = row + direct[0];
            int nextColumn = column + direct[1];
            if (nextRow<0 || nextRow>=matrix.length || nextColumn<0 || nextColumn>= matrix[0].length || visit[nextRow][nextColumn]){
                // 该转弯了
                directIndex = (directIndex+1) %4;
            }
            row += directions[directIndex][0];
            column += directions[directIndex][1];
        }
        return result;
    }

}
