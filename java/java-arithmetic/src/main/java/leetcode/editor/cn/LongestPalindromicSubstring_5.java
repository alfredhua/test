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
       String babad = solution.longestPalindrome("babad");
       System.out.println(babad);

       String cbbd = solution.longestPalindrome("cbbd");
       System.out.println(cbbd);

       String a = solution.longestPalindrome("a");
       System.out.println(a);

       String ac = solution.longestPalindrome("ac");
       System.out.println(ac);

       String b = solution.longestPalindrome("aacabdkacaa"); //aca
       System.out.println(b);
   }
   
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        String result="";
        for (int start=0;start<s.length();start++){
            for (int end=s.length()-1;end>=start;end--){
                if (s.charAt(start) != s.charAt(end)){
                    continue;
                }
                if (s.substring(start,end+1).length() > result.length()) {
                    result = s.substring(start, end+1);
                }
            }
        }
        return  result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

   
}