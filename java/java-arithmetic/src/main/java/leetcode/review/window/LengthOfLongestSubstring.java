package leetcode.review.window;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {


    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0;
        if (s==null||s.length()==0){
            return 0;
        }
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        while (end<s.length()){
            if(map.containsKey(s.charAt(end))){
                start = Math.max(start,map.get(s.charAt(end)) + 1);
            }
            map.put(s.charAt(end),end);
            ans = Math.max(ans,end-start+1);
            end++;
        }
        return ans;
    }
}
