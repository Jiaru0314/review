package com.xzq.algorithm.sort;

import java.util.Arrays;

/**
 * @ClassName: sort
 * @description: 冒泡排序
 * @author: XZQ
 * @create: 2020/3/23 21:57
 **/
public class BubbleSort implements IArraySort {

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        final int[] sortedArray = new BubbleSort().sort(arr);
        System.out.println("排序前");
        ArrayUtil.printArray(arr);
        System.out.println("\n排序后");
        ArrayUtil.printArray(sortedArray);
    }

    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int temp = 0;
        //外层循环的次数
        for (int i = 0; i < arr.length - 1; i++) {
            //内层比较的次数
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}

