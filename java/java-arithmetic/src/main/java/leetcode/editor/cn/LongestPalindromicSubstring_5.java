//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 👍 4561 👎 0

  
package leetcode.editor.cn;

public class LongestPalindromicSubstring_5{

   public static void main(String[] args) {
       Solution solution = new LongestPalindromicSubstring_5().new Solution();
//       String babad = solution.longestPalindrome("babad");
//       System.out.println(babad);
//
       String cbbd = solution.longestPalindrome("cbbd");
       System.out.println(cbbd);
//
//       String a = solution.longestPalindrome("a");
//       System.out.println(a);

//       String ac = solution.longestPalindrome("ac");
//       System.out.println(ac);
//
//       String b = solution.longestPalindrome("aacabdkacaa"); //aca
//       System.out.println(b);
   }

   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
       public String longestPalindrome(String s) {
           String result="";
           if (s==null || s.length()==1){
               return s;
           }
           for (int i=1;i<s.length()-1;i++){
               int start=i-1;
               int end =i+1;
               while (start>0 && end<s.length()-1){
                   if (s.charAt(start)== s.charAt(end)){
                       String substring = s.substring(start, end+1);
                       if (result.length() < substring.length()) {
                           result = substring;
                       }
                       start--;
                       end++;
                   }else{
                       break;
                   }
               }
           }
           if ("".equals(result)){
               return s.substring(0,1);
           }
           return result;
       }

   }
//leetcode submit region end(Prohibit modification and deletion)

   
}