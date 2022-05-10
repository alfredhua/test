package leetcode.offer;

import java.util.HashMap;

public class OfferLength_03 {


    public static void main(String[] args) {
        String a="abcabcbb";
        System.out.println(new OfferLength_03().lengthOfLongestSubstring(a));

        String b="pwwkew";
        System.out.println(new OfferLength_03().lengthOfLongestSubstring(b));
    }


    public int lengthOfLongestSubstring(String s) {
        if (s.length()<2){
            return s.length();
        }
        int left=0;
        int right =0;
        int result=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while (right<s.length()){
            if (map.containsKey(s.charAt(right))){
                left=Math.max(left,map.get(s.charAt(right))+1);
            }
            map.put(s.charAt(right),right);
            result=Math.max(result,right-left+1);
            right++;
        }
        return result;
    }
}
