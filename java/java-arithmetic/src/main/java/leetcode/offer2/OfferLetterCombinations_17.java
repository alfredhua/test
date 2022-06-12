package leetcode.offer2;

import java.util.*;

public class OfferLetterCombinations_17 {

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() != 0){
            dfs("",ans, digits);
        }
        return ans;
    }

    private void dfs(String result, List<String> ans, String digits){
        if (digits.length()==0){
            ans.add(result);
            return;
        }
        String next = digits.substring(0, 1);
        String s = phone.get(next);
        for (int i=0;i<s.length();i++){
            String letter = s.substring(i, i + 1);
            dfs(result + letter,ans, digits.substring(1));
        }
    }

}
