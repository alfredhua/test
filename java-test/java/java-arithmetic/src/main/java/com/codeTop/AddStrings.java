package com.codeTop;

public class AddStrings {

    public static void main(String[] args) {

        String s = new AddStrings().addStrings("11", "123");
        System.out.println(s);

    }

    public String addStrings(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int t = 0;
        while (i>=0 || j>=0){
            int x = 0;
            if (i>=0){
                x= num1.charAt(i)-'0';
            }
            int y = 0;
            if (j>=0){
                y = num2.charAt(j)-'0';
            }
            int res = x+y+t;
            if (res>=10){
                res = res - 10;
                t = 1;
            }else {
                t = 0;
            }
            sb.append(res);
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
