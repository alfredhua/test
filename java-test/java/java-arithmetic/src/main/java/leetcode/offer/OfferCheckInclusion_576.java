package leetcode.offer;

import java.util.Arrays;

public class OfferCheckInclusion_576 {

    public static void main(String[] args) {
        System.out.println(new OfferCheckInclusion_576().checkInclusion("ab","baooo"));
        System.out.println(new OfferCheckInclusion_576().checkInclusion("ab","eidboaoo"));
    }



    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        if (n>m){
            return false;
        }
        int[] cnt1=new int[26];
        for (int i=0;i<n;i++){
            cnt1[s1.charAt(i) - 'a']++;
        }
        int left=0;
        for (int right=0;right<s2.length();right++){
            int x=s2.charAt(right) - 'a';
            cnt1[x]++;
            while (cnt1[x]>0){
                cnt1[s2.charAt(left) - 'a']--;
                left++;
            }

        }

        return false;
    }

    public boolean checkInclusion1(String s1, String s2) {
        if (s1.length()>s2.length()){
            return false;
        }
        int [] countS1=new int[26];
        int [] countS2=new int[26];
        for (int i=0;i<s1.length();i++){
            countS1[s1.charAt(i) - 'a'] =  countS1[s1.charAt(i) - 'a']+1;
            countS2[s2.charAt(i) - 'a'] =  countS2[s2.charAt(i) - 'a']+1;
        }
        if (Arrays.equals(countS1,countS2)){
            return true;
        }
        for (int i=s1.length();i<s2.length();i++){
            ++countS2[s2.charAt(i) - 'a'];
            --countS2[s2.charAt(i - s1.length()) - 'a'];
            if (Arrays.equals(countS1, countS2)) {
                return true;
            }
        }
        return false;
    }
}
