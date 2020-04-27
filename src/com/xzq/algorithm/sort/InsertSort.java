package com.xzq.algorithm.sort;

import java.util.Arrays;

/**
 * @ClassName: InsertSort
 * @description:
 * @author: XZQ
 * @create: 2020/3/28 21:54
 **/
public class InsertSort implements IArraySort {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        final int[] sortedArray = new InsertSort().sort(arr);
        System.out.println("排序前:");
        ArrayUtil.printArray(arr);
        System.out.println("\n排序后:");
        ArrayUtil.printArray(sortedArray);
    }

    @Override
    public int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int index = i - 1;
            while (index >= 0 && insertValue < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = insertValue;
        }
        return arr;
    }
}
