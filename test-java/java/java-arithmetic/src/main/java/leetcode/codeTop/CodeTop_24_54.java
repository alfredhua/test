package leetcode.codeTop;

import java.util.ArrayList;
import java.util.List;

public class CodeTop_24_54 {

    public static void main(String[] args) {
        List<Integer> list = new CodeTop_24_54().spiralOrder(new int[][]{{1, 2, 3, 4}, {7, 8, 9, 19}, {5, 6, 10, 11}});
        System.out.println(list.toString());
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length<1){
            return result;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0, column = 0;
        int directionIndex = 0;
        for (int i =0;i<total;i++){
            result.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return result;
    }
}
