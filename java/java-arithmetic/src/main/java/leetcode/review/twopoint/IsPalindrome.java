package leetcode.review.twopoint;

public class IsPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = new IsPalindrome().isPalindrome(s);
        System.out.println(palindrome);
        String s2 = "race a car";

        boolean palindrome2 = new IsPalindrome().isPalindrome(s2);
        System.out.println(palindrome2);
    }

    public boolean isPalindrome(String s) {
        String x = "";
        s = s.toUpperCase();
        for (int i =0;i<s.length();i++){
            if ((s.charAt(i)>='a' && s.charAt(i)<='z')|| (s.charAt(i)>='A' && s.charAt(i)<='Z')){
                x =x + s.charAt(i);
            }
        }
        System.out.println(x);
        int left =0;
        int right =x.length()-1;
        while (left<right){
            if (x.charAt(left)!= x.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
