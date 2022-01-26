//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
// Related Topics 数学 字符串 模拟 👍 820 👎 0

  
package leetcode.editor.cn;

public class MultiplyStrings_43{

   public static void main(String[] args) {
       Solution solution = new MultiplyStrings_43().new Solution();
       System.out.println(solution.multiply("123","456"));
   }
   
   //leetcode submit region begin(Prohibit modification and deletion)
 class Solution {


       public String multiply(String num1, String num2) {
           if ("0".equals(num1)|| "0".equals(num2)){
               return "0";
           }
           int[] res = new int[num1.length() + num2.length()];
           for (int i=num1.length()-1;i>=0;i--){
               int n1 = num1.charAt(i) - '0';
               for (int j = num2.length()-1;j>=0;j--){
                   int n2= num2.charAt(j) - '0';
                   int sum = (res[i+j+1] + n1 *n2);
                   res[i+j+1] = sum % 10;
                   res[i+j] += sum /10;
               }
           }
           StringBuilder result = new StringBuilder();
           for (int i = 0; i < res.length; i++) {
               if (i == 0 && res[i] == 0){
                   continue;
               }
               result.append(res[i]);
           }
           return result.toString();
       }

       public String multiply2(String num1, String num2) {
           if (num1.equals("0") || num2.equals("0")) {
               return "0";
           }
           int[] res = new int[num1.length() + num2.length()];
           for (int i = num1.length() - 1; i >= 0; i--) {
               int n1 = num1.charAt(i) - '0';
               for (int j = num2.length() - 1; j >= 0; j--) {
                   int n2 = num2.charAt(j) - '0';
                   int sum = (res[i + j + 1] + n1 * n2);
                   res[i + j + 1] = sum % 10;
                   res[i + j] += sum / 10;
               }
           }

           StringBuilder result = new StringBuilder();
           for (int i = 0; i < res.length; i++) {
               if (i == 0 && res[i] == 0) continue;
               result.append(res[i]);
           }
           return result.toString();
       }
   }

//leetcode submit region end(Prohibit modification and deletion)

   
}