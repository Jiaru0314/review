package com.xzq.剑指offer._53_II_数组中缺失的数字;

/**
 * @ClassName: MissingNumber
 * @description:
 * @author: XZQ
 * @create: 2020/5/10 10:45
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 **/
public class MissingNumber {

    public static void main(String[] args) {
        int[] array = {0};
//        int[] array = {0, 1, 3};
//        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(new MissingNumber().missingNumber1(array));
        System.out.println(new MissingNumber().missingNumber2(array));
        System.out.println(new MissingNumber().missingNumber(array));
    }

    /*遍历 相加减 时间复杂度 O(n)*/
    public int missingNumber1(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += (-nums[i] + i);
        }
        return result + nums.length;
    }

    /*遍历 异或 时间复杂度 O(n)*/
    public int missingNumber2(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= (nums[i] ^ i);
        }
        return result ^ nums.length;
    }

    /*二分查找 时间复杂O(n)*/
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length <= 0)
            return -1;

        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == mid) {//中间元素和下标相等
                start = mid + 1;
            } else {//中间元素和下标不相等
                //如果前一个元素下标等于元素值 则当前元素下标就是缺失的那个数字
                if (mid == 0 || nums[mid - 1] == (mid - 1))
                    return mid;
                else
                    end = mid - 1; //如果前一个元素下标不等于元素值 则缺失元素在左边数组中
            }
        }
        if (start == nums.length)
            return start;
        return -1;
    }
}
