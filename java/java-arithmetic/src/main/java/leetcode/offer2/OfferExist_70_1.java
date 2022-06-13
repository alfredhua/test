package leetcode.offer2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author guozhenhua
 * @date 2022/6/13
 */
public class OfferExist_70_1 {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        for (int i=0;i<board.length;i++){
            for (int j = 0;j<board[0].length;j++){
                boolean[][] exists=new boolean[board.length][board[0].length];
                Deque<int[]> deque=new ArrayDeque();
                deque.add(new int[]{i,j});
                exists[i][j] = true;
                int n=0;
                while (!deque.isEmpty()){
                    int size = deque.size();
                    if (n==word.length()-1){
                        return true;
                    }
                    for (int k=0;k<size;k++){
                        int[] poll = deque.poll();
                        int x=poll[0],y=poll[1];
                        if (word.charAt(n)!=board[x][y]){
                            continue;
                        }
                        for (int[] dir:directions){
                            int nx=x+dir[0];
                            int ny=x+dir[1];
                            if (nx>=0 && nx<board.length && ny>=0 && ny<board[0].length &&!exists[nx][ny]){
                                exists[nx][ny] = true;
                                deque.add(new int[]{nx,ny});
                            }
                        }
                    }
                    n++;
                }
            }
        }
        return false;
    }
}
