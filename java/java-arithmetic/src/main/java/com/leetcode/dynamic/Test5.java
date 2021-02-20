package com.leetcode.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guozhenhua
 * date 2020/5/26.
 *
 * 给定正整数 N，返回小于等于 N 且具有至少 1 位重复数字的正整数的个数。
 *
 * 示例 1：
 *
 * 输入：20
 * 输出：1
 * 解释：具有至少 1 位重复数字的正数（<= 20）只有 11 。
 * 示例 2：
 *
 * 输入：100
 * 输出：10
 * 解释：具有至少 1 位重复数字的正数（<= 100）有 11，22，33，44，55，66，77，88，99 和 100 。
 * 示例 3：
 *
 * 输入：1000
 * 输出：262
 *
 */
public class Test5 {


    public static int numDupDigitsAtMostN(int N) {
        return N - dp(N);
    }

    //获取所有不重复的数据
    public static int dp(int n) {
        //将数字放在digit里
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }
        int k = digits.size();
        int[] used = new int[10];
        int total = 0;
        for (int i = 1; i < k; i++) {
            total += 9 * A(9, i - 1);
        }
        for (int i = k - 1; i >= 0; i--) {
            int num = digits.get(i);
            for (int j = i == k - 1 ? 1 : 0; j < num; j++) {
                if (used[j] != 0) {
                    continue;
                }
                total += A(10 - (k - i), i);
            }
            if (++used[num] > 1) {
                break;
            }
            if (i == 0) {
                total += 1;
            }
        }
        return total;
    }

    public static int fact(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public static int A(int m, int n) {
        return fact(m) / fact(m - n);
    }

    public static void main(String[] args) {
        System.out.println(numDupDigitsAtMostN(1000));
    }
}
