package com.xzq.剑指offer._21_调整数组顺序使奇数位于偶数之前;

import java.util.Arrays;

/**
 * @ClassName: ReorderArray
 * @description:面试题21 调整数组顺序使奇数位于偶数之前
 * @author: XZQ
 * @create: 2020/4/26 20:00
 * <p>
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
 * 奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * 思路
 * 　　对于任意一个整数数组，设置一个指针，从前往后走，如果遇到奇数则指针后移，
 * 遇到偶数时，希望把该偶数放在数组后面；因此，再设置一个指针，从后往前走，
 * 遇到偶数时指针前移，遇到奇数时，则恰好可以与前面的指针所指的偶数进行调换。
 **/
public class ReorderArray {

    /*判断其参数是不是偶数,如果是偶数就返回TRUE,否则返回FASLE*/
    public boolean isEven(int n) {
        return ((n & 1) == 0);
    }

    /*判断其参数是否是正数,如果是正数就返回TRUE,否则返回FASLE*/
    public boolean isPositive(int n) {
        return (n > 0);
    }

    public void reOrderArray2(int[] array) {
        if (array == null || array.length == 0)
            return;
        int temp = 0;
        int low = 0;
        int high = array.length - 1;

        while (low < high) {
            while (high >= 0 && (array[high] & 1) != 1) {//当array[high]不是奇数时
                high--;
            }
            while (low <= array.length && ((array[low] & 1) != 0)) {//当array[low]不是偶数时
                low++;
            }
            if (low < high) {
                temp = array[high];
                array[high] = array[low];
                array[low] = temp;
            }
        }
    }

    /*可扩展的*/
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0)
            return;
        int temp = 0;
        int low = 0;
        int high = array.length - 1;

        while (low < high) {
            while (high >= 0 && (isEven(array[high]))) {//当array[high]不是奇数时
                high--;
            }
            while (low <= array.length && (!isEven(array[low]))) {//当array[low]不是偶数时
                low++;
            }
            if (low < high) {
                temp = array[high];
                array[high] = array[low];
                array[low] = temp;
            }
        }
    }

    //===============测试代码===================
    void test1() {
        int[] array = null;
        System.out.println("原始数组：" + Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果：" + Arrays.toString(array));
        System.out.println();
    }

    void test2() {
        int[] array = {};
        System.out.println("原始数组：" + Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果：" + Arrays.toString(array));
        System.out.println();
    }

    void test3() {
        int[] array = {-2, 4, -6, 1, -3, 5};
        System.out.println("原始数组：" + Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果：" + Arrays.toString(array));
        System.out.println();
    }

    void test4() {
        int[] array = {-1, 3, -5, 2, -4, 6};
        System.out.println("原始数组：" + Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果：" + Arrays.toString(array));
        System.out.println();
    }

    void test5() {
        int[] array = {-1, 2, -3, 4, -5, 6};
        System.out.println("原始数组：" + Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果：" + Arrays.toString(array));
        System.out.println();
    }

    void test6() {
        int[] array = {2, 2, 1, 3, 4, 1};
        System.out.println("原始数组：" + Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果：" + Arrays.toString(array));
        System.out.println();
    }

    void test7() {
        int[] array = {1};
        System.out.println("原始数组：" + Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果：" + Arrays.toString(array));
        System.out.println();
    }

    public static void main(String[] args) {
        ReorderArray demo = new ReorderArray();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
    }
}
