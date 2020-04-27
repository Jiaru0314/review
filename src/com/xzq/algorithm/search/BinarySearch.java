package com.xzq.algorithm.search;

/**
 * @ClassName: BinarySearch
 * @description:
 * @author: XZQ
 * @create: 2020/3/28 21:35
 **/
public class BinarySearch implements IArraySearch {
    public static void main(String[] args) {
        int[] disorderArray = {1, 3, 5, 33, 76, 231, 322, 433, 533, 553, 644, 675, 1000};
        final int index = new BinarySearch().search(disorderArray, 533);
        System.out.println(index);
    }

    @Override
    public int search(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target == array[mid]) {
                return mid;
            } else if (target < array[mid]) {
                high = mid - 1;
            } else if (target > array[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }
}
