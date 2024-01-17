package leetcode.offer2;

import java.util.LinkedList;
import java.util.Queue;

public class OfferSolve_130 {

    int[][] dirs=new int[][]{{0,-1},{1,0},{0,1},{-1,0}};
    public void solve(char[][] board) {
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;
        Queue<int[]> queue=new LinkedList<>();
        //上下边界
        for (int i=0;i<board.length;i++){
            if (board[i][0]=='O'){
                queue.offer(new int[]{i,0});
                board[i][0] ='A';
            }
            if (board[i][m-1]=='O'){
                queue.offer(new int[]{i,m-1});
                board[i][m-1] ='A';
            }
        }
        //左右边界
        for (int j=0;j<m-1;j++){
            if (board[0][j]=='O'){
                queue.offer(new int[]{0,j});
                board[0][j] = 'A';
            }
            if (board[n-1][j] == 'O'){
                queue.offer(new int[]{n-1,j});
                board[n-1][j] = 'A';
            }
        }
        // 与边界相邻的都置为A
        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int[] dir:dirs){
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || board[nx][ny] != 'O') {
                    continue;
                }
                queue.offer(new int[]{nx,ny});
                board[nx][ny] = 'A';
            }
        }

        //遍历全部，将A换回o，其它都是X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
