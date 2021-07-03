package com.leetcode.arr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author guozhenhua
 * @date 2021/03/04
 *
 * 判断一个9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
 *x
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 *
 *
 * [
 *  ["5","3",".",".","7",".",".",".","."],
 *  ["6",".",".","1","9","5",".",".","."],
 *  [".","9","8",".",".",".",".","6","."],
 *  ["8",".",".",".","6",".",".",".","3"],
 *  ["4",".",".","8",".","3",".",".","1"],
 *  ["7",".",".",".","2",".",".",".","6"],
 *  [".","6",".",".",".",".","2","8","."],
 *  [".",".",".","4","1","9",".",".","5"],
 *  [".",".",".",".","8",".",".","7","9"]
 * ]
 */
public class SudoTest {



    public boolean isValidSudoku(char[][] board){
        Set<Integer> rowSet=new HashSet<>();
        Set<Integer> columnSet=new HashSet<>();
        Set<Integer> boxSet=new HashSet<>();
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                //行
                if (board[i][j]=='.'){
                }else{
                    if (rowSet.contains((int) board[i][j])){
                        return false;
                    }
                    rowSet.add((int) board[i][j]);
                }
                //列
                if (board[j][i]=='.'){
                }else{
                    if (columnSet.contains((int) board[j][i])){
                        return false;
                    }
                    columnSet.add((int) board[j][i]);
                }

                //3*3
                int row=i/3+(j/3)*3;
                int column=j/3+(i/3)*3;

                if (board[row][column]=='.'){
                }else{
                    if (boxSet.contains((int) board[row][column])){
                        return false;
                    }
                    boxSet.add((int) board[row][column]);
                }


            }
        }
        return true;
    }

//    public boolean isValidSudoku(char[][] board) {
//        int row[9][10] = {0};// 哈希表存储每一行的每个数是否出现过，默认初始情况下，每一行每一个数都没有出现过
//        // 整个board有9行，第二维的维数10是为了让下标有9，和数独中的数字9对应。
//        int col[9][10] = {0};// 存储每一列的每个数是否出现过，默认初始情况下，每一列的每一个数都没有出现过
//        int box[9][10] = {0};// 存储每一个box的每个数是否出现过，默认初始情况下，在每个box中，每个数都没有出现过。整个board有9个box。
//        for(int i=0; i<9; i++){
//            for(int j = 0; j<9; j++){
//                // 遍历到第i行第j列的那个数,我们要判断这个数在其所在的行有没有出现过，
//                // 同时判断这个数在其所在的列有没有出现过
//                // 同时判断这个数在其所在的box中有没有出现过
//                if(board[i][j] == '.') continue;
//                int curNumber = board[i][j]-'0';
//                if(row[i][curNumber]) return false;
//                if(col[j][curNumber]) return false;
//                if(box[j/3 + (i/3)*3][curNumber]) return false;
//                row[i][curNumber] = 1;// 之前都没出现过，现在出现了，就给它置为1，下次再遇见就能够直接返回false了。
//                col[j][curNumber] = 1;
//                box[j/3 + (i/3)*3][curNumber] = 1;
//            }
//        }
//        return true;
//    }

}
