//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
// 3---------0/(0,0),1/(0,1),2/(0,2),3/(1,1),4/(2,0)
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
// Related Topics 字符串 👍 1439 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion_6{

   public static void main(String[] args) {
       Solution solution = new ZigzagConversion_6().new Solution();
       String paypalishiring = solution.convert("PAYPALISHIRING", 3);
       System.out.println(paypalishiring.equals("PAHNAPLSIIGYIR"));
       String pinalsigyahrpi = solution.convert("PAYPALISHIRING", 4);
       System.out.println(pinalsigyahrpi.equals("PINALSIGYAHRPI"));
   }
   
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String convert(String s, int numRows) {
        if ( numRows < 2 ){
            return s;
        }
        // 按行 读取数据
        List<StringBuffer> rowList=new ArrayList<>();
        for (int i=0;i<Math.min(numRows,s.length());i++){
            rowList.add(new StringBuffer());
        }

        int currentRow=0;
        boolean goingDown=false;
        for (int i=0;i<s.length();i++){
            rowList.get(currentRow).append(s.charAt(i));
            if (currentRow==0||currentRow==numRows-1){
                goingDown=!goingDown;
            }
            currentRow+=goingDown?1:-1;
        }

        StringBuffer sb=new StringBuffer();
        for (StringBuffer row:rowList){
            sb.append(row);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

   
}