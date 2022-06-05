package leetcode.offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OfferFindAnagrams_438 {
    public static void main(String[] args) {

    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result= new ArrayList<>();
        if (s==null || p ==null || p.length()>s.length()){
            return result;
        }
        int[] pCount=new int[26];
        int[] sCount=new int[26];
        for (int i=0;i<p.length();i++){
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pCount,sCount)){
            result.add(0);
        }
        for (int i = 0; i<s.length()-p.length();i++){
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i+p.length()) - 'a']++;
            if (Arrays.equals(pCount,sCount)){
                result.add(i+1);
            }
        }
        return result;
    }

    private boolean equalWords(String s,String t){
        return false;
    }
}
