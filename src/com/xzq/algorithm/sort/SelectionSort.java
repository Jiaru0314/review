package com.xzq.algorithm.sort;

import java.util.Arrays;

/**
 * @ClassName: SelectionSort
 * @description:
 * @author: XZQ
 * @create: 2020/3/23 22:30
 **/
public class SelectionSort implements IArraySort {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        final int[] sortedArray = new SelectionSort().sort(arr);
        System.out.println("排序前");
        ArrayUtil.printArray(arr);
        System.out.println("\n排序后");
        ArrayUtil.printArray(sortedArray);
    }

    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }
}
