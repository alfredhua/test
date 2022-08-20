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


/**
 * i ------ j
 * [  0 1 2 3
 * 0 [1,0,0,0],
 * 1 [0,1,0,0],
 * 2 [1,0,1,0],
 * 3 [0,1,0,1],
 * j    ]
 */
  
package leetcode.editor.cn;

public class LongestPalindromicSubstring_5{

   public static void main(String[] args) {
       Solution solution = new LongestPalindromicSubstring_5().new Solution();
//       System.out.println(solution.isPalindrom("baba"));
//       System.out.println(solution.isPalindrom("bb"));
//       System.out.println(solution.isPalindrom("abba"));
//       System.out.println(solution.isPalindrom("a"));
       String babad = solution.longestPalindrome2("babad");
       System.out.println(babad);

       String cbbd = solution.longestPalindrome2("cbbd");
       System.out.println(cbbd);

       String a = solution.longestPalindrome2("a");
       System.out.println(a);

       String ac = solution.longestPalindrome2("ac");
       System.out.println(ac);

       String b = solution.longestPalindrome2("aacabdkacaa"); //aca
       System.out.println(b);
   }

   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

       public String longestPalindrome2(String s) {
           char[] chars = s.toCharArray();
           int len = s.length();
           boolean[][] isPa= new boolean[s.length()][s.length()];
           for (int i =0;i<isPa.length;i++){
               isPa[i][i] = true;
           }
           int begin=0,maxLen=0;
           // i ---- j  是否是回文
           for (int l =2;l<=s.length();l++){
               for (int i =0; i<s.length();i++){
                   int j = i+l -1; // 右边界
                   if (j>=len){
                       break;
                   }
                   if (chars[i]!=chars[j]){
                       isPa[i][j] = false;
                   }else {
                       if (j-i<3){
                           isPa[i][j] = true;
                       }else {
                           isPa[i][j]= isPa[i+1][j-1];
                       }
                   }
                   if (isPa[i][j] && j - i + 1 > maxLen) {
                       maxLen = j - i + 1;
                       begin = i;
                   }
               }
           }
           return s.substring(begin, begin + maxLen);
       }


       /**
        * 优化解法
        * @param s
        * @return
        */
       public String longestPalindrome(String s) {
           if ( "".equals(s)||s==null ){
               return s;
           }
           if ( s.length()<=1 ){
               return s;
           }

           String result="";
           boolean dp[][]= new boolean[s.length() ][s.length() ];
           //长度为1的字串都是回文
           for (int i=0;i<s.length()-1;i++){
               dp[i][i]=true;
           }
           int maxLen=0;
           int begin=0;
           for (int end=1;end<s.length();end++) {
               for (int start = 0; start < end; start++) {
//                 s 中从  start ----------> end
                   if (s.charAt(start)!=s.charAt(end)){
                       dp[start][end]=false;
                   }else{
                       // 去掉首 和尾 俩个 字符
                       if ((end-1)-(start+1) +1 <2){
                           dp[start][end]=true;
                       }else{
                           // 取决于字串 start+1 ----- end-1 之间是否是回文，
                           dp[start][end]=dp[start+1][end-1];
                       }
                   }
                   if (dp[start][end] && end- start+1 >maxLen){
                       maxLen=end-start+1;
                       begin=start;
                   }
               }
           }
           return s.substring(begin,begin+maxLen);
       }







       /**
        * 暴力解法
        * @param s
        * @return
        */
       public String longestPalindrome1(String s) {
           String result="";
           for (int i=0;i<s.length()-1;i++){
               int end=i;
               while (end<s.length()-1){
                   end++;
                   String substring = s.substring(i, end);
                   if (isPalindrom(substring)){
                       if (result.length()<substring.length()){
                           result=substring;
                       }
                   }
               }
           }
           return result;
       }

       public boolean isPalindrom(String s){
           int start=0;
           int end=s.length()-1;
           boolean flag=false;
           while (true){
               if (s.charAt(start) == s.charAt(end)){
                   start++;
                   end--;
               }else{
                   break;
               }
               if (end<=start){
                   flag=true;
                   break;
               }
           }
           return flag;
       }

   }
//leetcode submit region end(Prohibit modification and deletion)

   
}