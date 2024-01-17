//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2³¹, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 位运算 数学 👍 816 👎 0

  
package leetcode.editor.cn;

public class DivideTwoIntegers_29{

   public static void main(String[] args) {
       Solution solution = new DivideTwoIntegers_29().new Solution();
   }
   
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
       public int divide(int dividend, int divisor) {
           int sign = (dividend ^ divisor) >= 0 ? 1 : -1;//判断符号
           long dividendTemp = Math.abs((long) dividend);//求绝对值
           long divisorTemp = Math.abs((long) divisor);
           long res = 0;
           while (dividendTemp >= divisorTemp) {
               long tmp = divisorTemp;
               long times = 1;//除数divisor的倍数
               while (dividendTemp >= (tmp << 1)) {
                   tmp <<= 1;
                   times <<= 1;
               }
               //被除数减去除数的times倍
               dividendTemp -= tmp;
               //累加times
               res += times;
           }
           //添加符号
           res = sign > 0 ? res : -res;
           //需要判断是否有溢出
           return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
       }
   }
//leetcode submit region end(Prohibit modification and deletion)

   
}