package leetcode.review.twopoint;

public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("abc","ahbgdc"));

    }

    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==n;
    }
}
