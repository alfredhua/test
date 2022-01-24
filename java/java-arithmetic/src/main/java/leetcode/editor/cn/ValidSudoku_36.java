//请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 
//
// 注意： 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 空白格用 '.' 表示。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = 
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = 
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：false
//解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无
//效的。 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字（1-9）或者 '.' 
// 
// Related Topics 数组 哈希表 矩阵 👍 745 👎 0

  
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku_36{

   public static void main(String[] args) {
       Solution solution = new ValidSudoku_36().new Solution();
        char[][] board=new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
       System.out.println(solution.isValidSudoku(board));
   }
   
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

// 数字 1-9 在每一行只能出现一次。
// 数字 1-9 在每一列只能出现一次。
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）

    public boolean isValidSudoku(char[][] board) {
        int n=board.length;
        Map<Integer, Set<Integer>> columns=new HashMap<>();
        Map<Integer, Set<Integer>> seq=new HashMap<>();
        Map<Integer, Set<Integer>> area=new HashMap<>();
        for (int i=0;i<n;i++){
            columns.put(i,new HashSet<>());
            seq.put(i,new HashSet<>());
            area.put(i,new HashSet<>());
        }

        for (int i=0;i<n;i++){  //行
            for (int j=0;j<n;j++) { //列
                char value=board[i][j];
                if ('.'==value){
                    continue;
                }
                Integer intValue=Integer.parseInt(String.valueOf(board[i][j]));
                int k= i % 3 * 3 + j / 3;
                if (columns.get(i).contains(intValue) || seq.get(j).contains(intValue) || area.get(k).contains(intValue)){
                    return false;
                }else{
                    columns.get(i).add(intValue);
                    seq.get(i).add(intValue);
                    area.get(k).add(intValue);
                }

            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

   
}