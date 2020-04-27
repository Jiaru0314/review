package com.xzq.algorithm.sort;


import java.util.Arrays;

/**
 * @ClassName: QuickSort
 * @description: 快速排序
 * @author: XZQ
 * @create: 2020/2/21 20:16
 **/
public class QuickSort implements IArraySort {

    public static void main(String[] args)  {
        int[] sourceArray = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        final int[] sortedArray = new QuickSort().sort(sourceArray);
        System.out.println("排序前:");
        ArrayUtil.printArray(sourceArray);
        System.out.println("\n排序后:");
        ArrayUtil.printArray(sortedArray);
    }

    private int getIndex(int[] array, int low, int high) {
        int temp = array[low];
        while (low < high) {
            while (low < high && array[high] >= temp) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= temp) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = temp;
        return low;
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int index = getIndex(array, low, high);
            quickSort(array, 0, index - 1);
            quickSort(array, index + 1, high);
        }
    }


    @Override
    public int[] sort(int[] sourceArray)  {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }
}
