package com.xzq.leetcode._面试题_17_01.不用加号的加法;

/**
 * @ClassName: AddWithoutSub
 * @description:
 * @author: XZQ
 * @create: 2020/5/2 19:15
 * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
 * <p>
 * 输入: a = 1, b = 1
 * 输出: 2
 **/
public class AddWithoutSub {

    /*平方差公式 有溢出风险
     *（a+b)(a-b) = a*a-b*b
     * a+b = (a*a-b*b)/(a-b)
     * */
    public int add2(int a, int b) {
        return a == b ? a * 2 : (a * a - b * b) / (a - b);
    }

    /*位运算
     * 0+1 0+0 0+0 1+1 不考虑进位结果都是1 与异或相同 可以用异或还运算
     * 1+1 有进位 转化为&运算 然后左移一位 与第一步相加
     * */
    public int add(int a, int b) {
        int num, carry;
        do {
            num = a ^ b;
            carry = (a & b) << 1;//进位
            a = num;
            b = carry;
        } while (carry != 0);
        return num;
    }
}
