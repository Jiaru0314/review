package com.xzq.leetcode._507_完美数;

/**
 * @ClassName: PerfectNumber
 * @description:
 * @author: XZQ
 * @create: 2020/5/5 16:22
 **/
public class PerfectNumber {

    public static void main(String[] args) {
        System.out.println(new PerfectNumber().checkPerfectNumber(28));
    }


    public boolean checkPerfectNumber(int num) {
        if (num == 1)
            return false;
        int sum = 0;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        return num == sum + 1;
    }
}
