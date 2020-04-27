package com.xzq.leetcode;

/**
 * @ClassName: PalindromeDemo
 * @description: 题目：判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 * @author: XZQ
 * @create: 2020/4/5 12:50
 **/
public class PalindromeDemo {
    public static void main(String[] args) {
//        System.out.println(isPalindrome(11));
        System.out.println(isPalindrome2(10010));

    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0) && x != 0)
            return false;
        int res = 0;
        int y = x;
        for (; y != 0; res = res * 10 + y % 10, y = y / 10) ;
        return res == x;
    }


    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int help = 1;
        int tmp = x;

        while (tmp >= 10) {
            help *= 10;
            tmp /= 10;
        }
        /*121*/
        while (x != 0) {
            if (x % 10 != x / help) {
                return false;
            }
            x = x % 10 / help;
            help /= 100;
        }
        return true;
    }
}
