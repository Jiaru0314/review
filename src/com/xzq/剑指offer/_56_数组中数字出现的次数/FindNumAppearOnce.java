package com.xzq.剑指offer._56_数组中数字出现的次数;

/**
 * @ClassName: FindNumAppearOnce
 * @description:
 * @author: XZQ
 * @create: 2020/5/7 20:27
 * 题目 数组中出现的次数
 * 整型数组中只有两个数字出现了一次，其余都出现了两次，请找出这两个数
 **/
public class FindNumAppearOnce {
    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 3, 6, 3, 2, 5, 5};
//        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        new FindNumAppearOnce().find(array);
    }

    /*找出出现一次的数字*/
    public void find(int[] array) {
        //特殊条件判断
        if (array == null || array.length < 2)
            return;

        int num = fun(array);//循环数组 异或后的结果
        int index = findFirstBitIs1(num);//找出异或后结果中第一位为1的下标 用于区分两个数组

        int num1 = 0, num2 = 0;//定义两个结果 0异或任何数字 都是他本身
        for (int i = 0; i < array.length; i++) {
            if (isBit1(array[i], index)) {//如果第index位是1
                num1 ^= array[i];
            } else {
                num2 ^= array[i];
            }
        }
        System.out.println(num1);
        System.out.println(num2);
    }


    /*循环一边数组并异或，返回异或后的结果*/
    public int fun(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result = result ^ array[i];
        }
        return result;
    }

    /*找出异或后结果中第一个为1的位置*/
    public int findFirstBitIs1(int num) {
        int mark = 1;
        while (num != 0) {
            if ((num & 1) != 1) {//如果当前位为0
                num = num >> 1;
                mark++;
            } else {
                return mark;
            }
        }
        return 0;
    }

    /*判断从右往左第index位是不是1*/
    public boolean isBit1(int num, int index) {
        num = num >> (index - 1);
        return ((num & 1) == 1);
    }
}
