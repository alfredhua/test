package leetcode.review.matrix;

public class IsValidSudoku {

    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        int [][] rows = new int[9][9];
        int [][] columns = new int[9][9];
        int [][][] subSudo = new int[3][3][9];

        for (int i =0;i<board.length;i++){
            for (int j =0;j<board[i].length;j++){
                if (board[i][j]=='.'){
                    int index = board[i][j] - '0' -1; // 获取位置
                    rows[i][index]++;  // 判断行位置处+1
                    columns[j][index]++; // 判断列位置处+1
                    subSudo[i/3][j/3][index] ++; // 3 *3 的方格里 +1
                    if (rows[i][index]>1 || columns[j][index]>1 || subSudo[i/3][j/3][index]>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}