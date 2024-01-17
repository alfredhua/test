package com.codeTop;

public class LongestPalindrome {

    public static void main(String[] args) {
        String babad = new LongestPalindrome().longestPalindrome("babad");
        System.out.println(babad);

    }

    public String longestPalindrome(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        // 从i 到 j
        for (int i = 0;i<length;i++){
            for (int j =i;j<length;j++){
                boolean a = s.charAt(i) == s.charAt(j);
                if (j-i+1 == 2 && a){
                    dp[i][j] = 2;
                }
                if (j-i+1>2 && a && dp[i+1][j-1]>0){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
            }
        }

        int maxLen = 0;
        String str = "";
        for (int p = 0; p < length; p++) {
            for (int q = 0; q < length; q++) {
                if (dp[p][q] == 0 ) continue;
                if (dp[p][q] > maxLen) {
                    maxLen = dp[p][q];
                    str = s.substring(p, q + 1);
                }
            }
        }
        return str;
    }
}
