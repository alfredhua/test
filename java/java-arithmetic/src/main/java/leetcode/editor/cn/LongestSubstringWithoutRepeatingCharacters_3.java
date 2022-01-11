//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 6721 👎 0

  
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters_3{

   public static void main(String[] args) {
       Solution solution = new LongestSubstringWithoutRepeatingCharacters_3().new Solution();
       int pwwkew = solution.lengthOfLongestSubstring("pwwkew");
       System.out.println(pwwkew);
       int abcabcbb = solution.lengthOfLongestSubstring("abcabcbb");
       System.out.println(abcabcbb);
       int bbbb = solution.lengthOfLongestSubstring("bbbb");
       System.out.println(bbbb);
   }
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start=0;
        int result=0;
        Map<Character,Integer> map=new HashMap<>();
        for (int end=0;end<s.length();end++){
            if (map.containsKey(s.charAt(end))){
                start=Math.max(map.get(s.charAt(end)),start);
            }
            // 不包含
            result = Math.max(result,end-start+1);
            map.put(s.charAt(end),end+1);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}