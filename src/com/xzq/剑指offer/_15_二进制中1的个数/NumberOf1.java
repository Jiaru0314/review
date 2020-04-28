package com.xzq.剑指offer._15_二进制中1的个数;

/**
 * @ClassName: NumberOf1
 * @description:
 * @author: XZQ
 * @create: 2020/4/26 13:58
 **/
public class NumberOf1 {
    public static void main(String[] args) {
        System.out.println(7>>1);
    }

    public int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {//如果当前位是1
                count++;
            }
            // 注意此处要使用无符号右移，因为对于负数>>右移，高位补1，而无符号右移>>>，高位补0，适用此处场景
            n = n >>> 1;
        }
        return count;
    }

    public int numberOf1II(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

}
