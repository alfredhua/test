package com.leetcode.test.test1.chapter00006;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * LCIR ETOESIIG EDHN
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 3,2,1                4   3
 * 0-----4------8-------12 0 6-2  4--0---4--0    3 ------   3*2-2
 * 1---3---5--7---9--11    1 4-2  2--2---2--2
 * 2--------6------10      2 2-2   0--4---0--4
 *
 *
 * L      o      r
 * E   T  E    D f
 * E C    D  A   g
 * T      I      g
 * 0------6------12----   0  8-2  6--0--6--0        4  -----   4*2-2
 *  1----5-7---11--13--   1  8-4  4--2--4--2
 *   2--4---8-10----14    2  8-6  2---4---2--4
 *    3------9--------15  3  8-8  0---6---0--6
 *
 *
 */
public class Solution {

    public String convert(String s, int numRows) {
//        if (numRows == 1) return s;
//        StringBuffer result=new StringBuffer();
//        int size=numRows*2-2;  //间隔---
//        for (int i=0;i<numRows;i++){
//            for (int j = 0; j + i < s.length(); j += size) {
//                result.append(s.charAt(j + i));
//                if (i != 0 && i != numRows - 1 && j + size - i < s.length()){
//                    System.out.println(j + size - i);
//                     result.append(s.charAt(j + size - i));
//                }
//            }
//        }
//        return result.toString();


        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();

    }

    public static void main(String[] args) {
        String a=  new Solution().convert("LEETCODEISHIRING",3);
        System.out.println(a);
    }

}
