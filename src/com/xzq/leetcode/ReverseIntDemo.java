package com.xzq.leetcode;

/**
 * @ClassName: ReverseIntDemo
 * @description:
 * @author: XZQ
 * @create: 2020/4/5 10:35
 **/
public class ReverseIntDemo {
    public static void main(String[] args) {
        System.out.println(reverse(1056389939));
        System.out.println(reverse2(1056389939));
    }

    public static int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

    public static int reverse2(int x) {
        long res = 0;
        for (; x != 0; res = res * 10 + x % 10, x = x / 10) ;
        return (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) ? 0 : (int) res;
    }
}
