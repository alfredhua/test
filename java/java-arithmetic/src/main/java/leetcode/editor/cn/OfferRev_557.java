package leetcode.editor.cn;

public class OfferRev_557 {

    public static void main(String[] args) {
        OfferRev_557 offerRev_557 = new OfferRev_557();
    }

    public String reverseWords1(String s) {
        if(s.length()<1){
            return s;
        }
        String[] words = s.split(" ");
        StringBuilder result= new StringBuilder();
        for(String word:words){
            word=reverseString(word.toCharArray());
            result.append(word).append(" ");
        }
        return result.substring(0,result.length()-1);
    }

    public String reverseString(char[] s) {
        int right = s.length-1;
        int left = 0;
        while(left<right){
            char temp = s[right];
            s[right]= s[left];
            s[left] = temp;
            left++;
            right--;
        }
        return String.valueOf(s);
    }
}
