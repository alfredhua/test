package leetcode.review.arr;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] a = {"flower","flow","flight"};
        String s = new LongestCommonPrefix().longestCommonPrefix(a);
        System.out.println(s);

        String[] b = {"clower","dlow","flight"};
        String c = new LongestCommonPrefix().longestCommonPrefix(b);
        System.out.println(c);
    }

    public String longestCommonPrefix(String[] strs) {
        String  preFix= strs[0];
        for (int i =1;i<strs.length;i++){
            preFix = longestCommonPrefix(preFix,strs[i]);
            // 没有公共前缀
            if (preFix.length()==0){
                break;
            }
        }
        return preFix;
    }

    /**
     * 比较 S1 和 S2 的最长公共前缀
     * @param s1
     * @param s2
     * @return
     */
    public String longestCommonPrefix(String s1,String s2){
        int length =Math.min(s1.length(),s2.length());
        int index =0;
        while (index<length && s1.charAt(index)==s2.charAt(index)){
            index++;
        }
        return s1.substring(0,index);
    }

}
