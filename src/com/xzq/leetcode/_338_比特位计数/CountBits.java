package com.xzq.leetcode._338_比特位计数;

import com.xzq.algorithm.sort.ArrayUtil;

/**
 * @ClassName: CountBits
 * @description: 比特位计数
 * @author: XZQ
 * @create: 2020/4/29 15:25
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * https://leetcode-cn.com/problems/counting-bits/
 * <p>
 * 输入: 2
 * 输出: [0,1,1]
 **/
public class CountBits {

    public static void main(String[] args) {
        int[] array = new CountBits().count(2);
        ArrayUtil.printArray(array);
    }


    /*3ms*/
    public int[] count(int num) {

        int[] array = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            array[i] = numberOf1(i);
        }
        return array;
    }


    public int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
