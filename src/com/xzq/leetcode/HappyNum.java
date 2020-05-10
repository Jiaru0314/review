package com.xzq.leetcode;

import java.util.HashSet;

/**
 * @ClassName: HappyNum
 * @description: 快乐数
 * @author: XZQ
 * @create: 2020/4/30 10:52
 **/
public class HappyNum {

    public boolean isHappyNum(int n) {
        if (n < 1) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            int sum = 0;
            set.add(n);
            while (n > 0) {
                sum += Math.pow(n % 10, 2);
                n = n / 10;
            }
            n = sum;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNum().isHappyNum(4));
    }
}
