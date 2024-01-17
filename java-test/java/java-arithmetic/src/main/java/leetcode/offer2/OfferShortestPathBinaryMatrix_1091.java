package leetcode.offer2;

import java.util.LinkedList;
import java.util.Queue;

public class OfferShortestPathBinaryMatrix_1091 {

    public static void main(String[] args) {

    }

    int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,1},{1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid){
        int result =1;
        if (grid[0][0] != 0){
            return -1;
        }
        int m = grid.length;
        if (m == 1){
            return 1;
        }
        Queue<int[]> queue=new LinkedList();
        queue.offer(new int[]{0,0}); //从0开始走
        grid[0][0] = 1;  // 走过的为1
        while (!queue.isEmpty()){
            //下一个位置
            int size = queue.size();
            for (int i=0;i<size;i++) {
                int[] current = queue.poll();
                int x = current[0], y = current[1];
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < m && grid[nx][ny] == 0) {
                        if (nx == m - 1 && ny == m - 1) {
                            return result + 1;
                        }
                        queue.offer(new int[]{nx, ny});
                        grid[nx][ny]=1;
                    }
                }
            }
            result=result+1;
        }
        return -1;
    }


}
