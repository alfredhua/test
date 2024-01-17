package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

public class OfferLetterCasePermutation_784 {


    public static void main(String[] args) {

        List<String> a1b2 = new OfferLetterCasePermutation_784().letterCasePermutation("a1b2");
        System.out.println(a1b2);

    }

    public List<String> letterCasePermutation(String s) {
        List<String> list=new ArrayList<>();
        if (s.length()<1){
            return list;
        }
        char[] chars = s.toCharArray();
        dfs(0,chars,list);
        return list;
    }

    private void  dfs(int start,char[] s, List<String> list){
        list.add(new String(s));
        for (int i=start;i<s.length;i++ ) {
            if (s[i] >= '1' && s[i] <= 9) {
                continue;
            }
            if (Character.isLetter(s[i]) ) {
                s[i] = changeLetter(s[i]);
                dfs(i+1,s,list);
                s[i] = changeLetter(s[i]);
            }
        }
    }

    public char changeLetter(char c) {
        return (c >= 'a' && c <= 'z') ? (char) (c - 32) : (char) (c + 32);
    }

}
