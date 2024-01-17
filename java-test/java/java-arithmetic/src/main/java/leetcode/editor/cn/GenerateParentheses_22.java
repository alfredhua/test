//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
//
//
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2285 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22{

   public static void main(String[] args) {
       Solution solution = new GenerateParentheses_22().new Solution();
       System.out.println(solution.generateParenthesis(3));
   }
   
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        if (n<1 || n>8){
            return res;
        }
        def("",n,n,res);
        return res;
    }

    private void def(String c,int left,int right,List<String> res){
        if ( left==0 && right==0 ){
            res.add(c);
            return;
        }
        if ( left>right ){
            return;
        }
        if ( left>0 ){
             def(c+"(",left-1,right,res);
        }
        if ( right>0 ){
            def(c+")",left,right-1,res);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

   
}