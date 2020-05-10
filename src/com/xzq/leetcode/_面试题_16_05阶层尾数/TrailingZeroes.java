package com.xzq.leetcode._面试题_16_05阶层尾数;

/**
 * @ClassName: TrailingZeroes
 * @description: 设计一个算法，算出 n 阶乘有多少个尾随零。
 * @author: XZQ
 * @create: 2020/4/30 18:55
 * https://leetcode-cn.com/problems/factorial-zeros-lcci/
 **/
public class TrailingZeroes {

    public static void main(String[] args) {
        System.out.println(new TrailingZeroes().trailingZeroes(20));
    }


    /*思路：
     * 有多少个尾随0就是有多少个10
     * 10 = 2 * 5
     * 2的个数大于5
     * 转为计算5的个数
     * */
    public int trailingZeroes(int n) {
        if (n < 5)
            return 0;
        int result = 0;
        while (n != 0) {
            result += n / 5;
            n /= 5;
        }
        return result;
    }
}
