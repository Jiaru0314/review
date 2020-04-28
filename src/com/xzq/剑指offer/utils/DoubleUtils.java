package com.xzq.剑指offer.utils;

/**
 * @ClassName: DoubleUtils
 * @description:
 * @author: XZQ
 * @create: 2020/4/27 20:30
 **/
public class DoubleUtils {

    /*
     * 判断两个浮点数是否相等
     */
    public static boolean isDoubleEqual(double num1, double num2) {
        return (Math.abs(num1 - num2) <= 0) ? true : false;
    }
}
