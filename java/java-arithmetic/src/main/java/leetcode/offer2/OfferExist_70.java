package leetcode.offer2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author guozhenhua
 * @date 2022/6/13
 */
public class OfferExist_70 {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        for (int i=0;i<board.length;i++){
            for (int j = 0;j<board.length;j++){
                Deque<int[]> deque = new ArrayDeque();
                deque.add(new int[]{i,j});
                while (!deque.isEmpty()){
                    int[] poll = deque.poll();
                    int x= poll[0],y = poll[1];
                    for (int[] dir:directions){
                        int nx = x +dir[0];
                        int ny = y +dir[y];
                        if (nx>=0 && nx<board.length && ny>=0 && ny<board[0].length ){

                        }
                    }
                }
            }
        }
        return false;
    }
}
