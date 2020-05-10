package com.xzq.leetcode._441_排列硬币;

/**
 * @ClassName: ArrangingCoins
 * @description:
 * @author: XZQ
 * @create: 2020/5/8 16:59
 **/
public class ArrangingCoins {
    public static void main(String[] args) {
        System.out.println(new ArrangingCoins().arrangeCoins(8));
    }

    public int arrangeCoins(int n) {
        int i = 1;
        for (; n - i > 0; i++) {
            n = n - i;
        }
        return i - 1;
    }


    public int arrangeCoin(int n) {
        int count = 1;
        while (n - count >= 0) {
            n -= count;
            count++;
        }
        return count - 1;
    }
}
