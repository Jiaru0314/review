package com.xzq.剑指offer._63_股票的最大利润;

/**
 * @ClassName: MaxProfit
 * @description: 股票的最大利润
 * @author: XZQ
 * @create: 2020/5/9 14:11
 **/
public class MaxProfit {

    public static void main(String[] args) {
        int[] array = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(new MaxProfit().getMaxProfit(array));
    }

    public int getMaxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int min = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min)//如果当前值小于最小值 将最小值换成当前值
                min = prices[i];
            else {
                result = Integer.max(result, prices[i] - min);
            }
        }
        return result;
    }

    public int getMaxProfit2(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;

        for (int price : prices) {
            cost = Integer.min(cost, price);
            profit = Integer.max(profit, price - cost);
        }
        return profit;
    }

}
