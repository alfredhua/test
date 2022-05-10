package leetcode.codetop;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Top_01 {

    public static void main(String[] args) {
        String  a="abcabcbb";
        int i = new Top_01().lengthOfLongestSubstring(a);
        System.out.println(i);
    }


    public int lengthOfLongestSubstring(String s) {
        int start =0;
        int end =0;
        Set<Character> set=new HashSet<>();
        int result=0;
        while (start < s.length() && end <s.length()){
            if (!set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                end++;
                result=Math.max(result,end-start);
            }else{
                set.remove(s.charAt(end));
                start++;
            }
        }
        return result;
    }

 /*   public int lengthOfLongestSubstring(String s) {
        if (s==null || "".equals(s)){
            return 0;
        }
        int max = 0;
        int left = 0;
        Map<Character,Integer> map=new HashMap<>();
        for (int i=0;i<s.length();i++){
            if (map.containsKey(s.charAt(i))){
                left=Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max=Math.max(max,i-left+1);
        }
        return max;
    }*/
}
