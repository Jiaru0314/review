package com.xzq.leetcode._面试题_17_04消失的数字;

/**
 * @ClassName: MissingNumber
 * @description:
 * @author: XZQ
 * @create: 2020/4/30 17:44
 * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 * https://leetcode-cn.com/problems/missing-number-lcci/
 **/
public class MissingNumber {
    public static void main(String[] args) {
        int[] array = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(new MissingNumber().findMiss2(array));
    }

    /*求和相减*/
    public int findMiss(int[] nums) {
        int result = 0;
        int i = 0;
        for (; i < nums.length; i++) {
            result = result + i - nums[i];
        }
        return result + i;
    }

    /*异或*/
    public int findMiss2(int[] nums) {
        int result = 0;
        int i = 0;
        for (; i < nums.length; i++) {
            result = result ^ i ^ nums[i];
        }
        return result ^ i;
    }
}
