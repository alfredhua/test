package leetcode.offer2;

public class OfferBackSpaceCompare_844 {

    public static void main(String[] args) {
        boolean b = new OfferBackSpaceCompare_844().backspaceCompare("ab#c", "ab#c");
        System.out.println(b);
    }

    public boolean backspaceCompare(String s, String t) {
        return convert(s).equals(convert(t));
    }
    private String convert(String s){
        StringBuilder sb=new StringBuilder();
        char[] chars = s.toCharArray();
        int size =0;
        for (int i =chars.length-1; i >=0 ;i--){
            if (chars[i] == '#'){
                size++;
            }else if (size==0){
                sb.append(chars[i]);
            }else {
                size--;
            }

        }
        return sb.toString();
    }

}
