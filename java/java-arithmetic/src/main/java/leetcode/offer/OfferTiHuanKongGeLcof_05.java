package leetcode.offer;
//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
//
//
// 示例 1：
//
// 输入：s = "We are happy."
//输出："We%20are%20happy."
//
//
//
// 限制：
//
// 0 <= s 的长度 <= 10000
// Related Topics 字符串 👍 276 👎 0
public class OfferTiHuanKongGeLcof_05 {

    public static void main(String[] args) {
        OfferTiHuanKongGeLcof_05 offerTiHuanKongGeLcof_05 = new OfferTiHuanKongGeLcof_05();
        System.out.println(offerTiHuanKongGeLcof_05.replaceSpace("we are happy"));

    }

    public String replaceSpace(String s) {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (" ".equals(String.valueOf(c))){
                sb.append("%20");
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }



}
