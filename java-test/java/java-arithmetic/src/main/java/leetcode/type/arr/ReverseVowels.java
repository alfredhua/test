package leetcode.type.arr;

public class ReverseVowels {
    public static void main(String[] args) {

        String leetcode = new ReverseVowels().reverseVowels("leetcode");
        System.out.println(leetcode);
    }

    public String reverseVowels(String s) {
        int left =0;
        int right = s.length() -1 ;
        char[] chars = s.toCharArray();

        while (left<right){
            if (!vowel(chars[left])){
                left++;
                continue;
            }
            if (!vowel(chars[right])){
                right--;
                continue;
            }
            char temp = chars[left];
            chars[left]= chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    private boolean vowel(char vow) {
        if (vow == 'a' || vow == 'e' || vow == 'i' || vow == 'o' || vow == 'u' || vow == 'A' || vow == 'E' || vow == 'I' || vow == 'O' || vow == 'U')
            return true;
        else
            return false;
    }

}
