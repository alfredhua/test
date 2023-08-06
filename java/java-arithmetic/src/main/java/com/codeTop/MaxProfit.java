package com.codeTop;

public class MaxProfit {

    public static void main(String[] args) {
        int i = new MaxProfit().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {

        int minPrice=Integer.MAX_VALUE;
        int result = 0;

        for (int i =0;i<prices.length;i++){
            if (prices[i]<minPrice){
                minPrice = prices[i];
            }
            if (prices[i] - minPrice > result){
                result = prices[i] - minPrice;
            }
        }

        return result;
    }
}
