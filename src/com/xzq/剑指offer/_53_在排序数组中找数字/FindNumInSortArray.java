package com.xzq.剑指offer._53_在排序数组中找数字;

/**
 * @ClassName: FindNumInSortArray
 * @description: 在排序数组中找数字
 * @author: XZQ
 * @create: 2020/5/10 9:33
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 **/
public class FindNumInSortArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 3, 4, 5};
        int[] array3 = {5, 7, 7, 8, 8, 10};
        System.out.println(new FindNumInSortArray().getFirstKey(array3, 0, array3.length - 1, 8));
        System.out.println(new FindNumInSortArray().getLastKey(array3, 0, array3.length - 1, 8));
        System.out.println(new FindNumInSortArray().findNum(array3, 8));
    }

    /*查找数字k在有序数组中出现的次数 如果不存在 就返回-1*/
    public int findNum(int[] array, int k) {
        /*特殊条件判断*/
        if (array != null && array.length > 0) {
            int firstIndex = getFirstKey(array, 0, array.length - 1, k);
            if (firstIndex == -1)
                return 0;//如果没有 提前返回
            int lastIndex = getLastKey(array, 0, array.length - 1, k);

            return lastIndex - firstIndex + 1;
        }
        return 0;
    }

    /*找到数组中数字K第一次出现的次数 如果不存在 就返回-1*/
    public int getFirstKey(int[] array, int start, int end, int k) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        if (array[mid] == k) {//如果当前值等于k
            if (mid > 0 && array[mid - 1] != k || mid == 0)//如果mid之前的一位不是k,当前就是第一个k所在的位置
                return mid;
            end = mid - 1;//说明第一个k在前半段数组中
        } else if (array[mid] < k) {//在后半段数组中
            start = mid + 1;
        } else {//在前半段
            end = mid - 1;
        }
        return getFirstKey(array, start, end, k);
    }

    /*找到数组中数字K最后一次出现的次数*/
    public int getLastKey(int[] array, int start, int end, int k) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        if (array[mid] == k) {//如果当前值等于k
            //如果mid的后一位不是k,当前就是最后一个k所在的位置
            if (mid < array.length - 1 && array[mid + 1] != k || mid == array.length - 1)
                return mid;
            start = mid + 1;//说明最后一个k在后半段数组中
        } else if (array[mid] < k) {//在后半段数组中
            start = mid + 1;
        } else {//在前半段
            end = mid - 1;
        }
        return getLastKey(array, start, end, k);
    }
}
