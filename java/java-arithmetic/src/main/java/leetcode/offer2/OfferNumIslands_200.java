package leetcode.offer2;

import java.util.LinkedList;
import java.util.Queue;

public class OfferNumIslands_200 {
    public static void main(String[] args) {

    }

    int[][] directs=new int[][]{{0,-1},{1,0},{0,1},{-1,0}};

    public int numIslands(char[][] grid) {
        int count=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j] == '1') {
                    // 4个方向
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i,j});
                    while (!queue.isEmpty()){
                        int[] current = queue.poll();
                        int x = current[0];
                        int y = current[1];
                        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
                            grid[x][y] = '0';
                            for (int[] dir : directs) {
                                int newX = x + dir[0];
                                int newY = y + dir[1];
                                queue.add(new int[]{newX,newY});
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }


}
