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
        boolean[][] exists=new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j = 0;j<board[0].length;j++){
                 if(check(board,exists,i,j,word,0)){
                     return true;
                 }
            }
        }
        return false;
    }


    private boolean check(char[][] board,boolean[][] exists,int x, int y,String word,int index){
        if (board[x][y]!=word.charAt(index)){
            return false;
        }
        if (index==word.length()-1){
            return true;
        }
        exists[x][y] = true;
        boolean result =false;
        for (int[] dir:directions){
            int nx = x + dir[0], ny = y + dir[1];
            if (nx>=0 && nx<board.length && ny>=0 && ny<board[0].length &&!exists[nx][ny]){
                boolean flag = check(board,exists,nx,ny,word,index+1);
                if (flag){
                    result = true;
                    break;
                }
            }

        }
        exists[x][y] = false;
        return result;
    }

}
