package com.leetcode.arr;

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
 */
public class SudoTest {

    public boolean isValidSudoku(char[][] board) {
        for (int i=0;i<board.length;i++){
            for (int j=1;j<board.length;j++){
                if (board[i]==board[j]){
                    return false;  //行有重复的
                }
            }
        }
        return false;
    }



}
