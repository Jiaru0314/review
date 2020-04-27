package com.xzq.leetcode.LCP_06;

/**
 * @ClassName: TakeCoins
 * @description:
 * @author: XZQ
 * @create: 2020/4/27 13:17
 **/
public class TakeCoins {

    public static void main(String[] args) {
        int[] coins = {4, 2, 1};
        System.out.println(new TakeCoins().minCount(coins));
    }

    /*解法1*/
    public int minCount(int[] coins) {
        if (coins == null || coins.length <= 0)
            return 0;
        int ans = 0;
        for (int n : coins) {
            ans += ((n & 1) == 1) ? ((n >> 1) + 1) : n >> 1;
        }
        return ans;
    }

    /*解法2*/
    public int minCount2(int[] coins) {
        if (coins == null || coins.length <= 0)
            return 0;
        int ans = 0;
        for (int n : coins) {
            ans += (n + 1) >> 1;
        }
        return ans;
    }
}
