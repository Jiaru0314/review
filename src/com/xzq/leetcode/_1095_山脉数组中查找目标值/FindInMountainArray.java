package com.xzq.leetcode._1095_山脉数组中查找目标值;

/**
 * @ClassName: FindInMountainArray
 * @description: leetcode 1095_山脉数组中查找目标值
 * @author: XZQ
 * @create: 2020/4/29 13:47
 * 这是一个 交互式问题
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
 * 如果不存在这样的下标 index，就请返回 -1。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-in-mountain-array
 **/
public class FindInMountainArray {
    /*思路 首先二分查找，找到山脉，即最大值peak
     * 然后 对左边进行二分查找如果找到就返回
     * 如果没有找到，对右边二分查找*/
    public int findInMountainArray(int target, int[] mountainArr) {
        int peak = findPeak(mountainArr);
        int index = findTargetIndex(mountainArr, 0, peak + 1, 3);
        return index == -1 ? findTargetIndex(mountainArr, peak, mountainArr.length, 3) : index;

    }

    public int findTargetIndex(int[] mountainArr, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (mountainArr[mid] == target)
                return mid;//找到 返回下标
            if (mountainArr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;//没找到对应的下标 返会-1
    }

    private int findPeak(int[] mountainArr) {
        int mid;
        int left = 0;
        int right = mountainArr.length - 1;

        while (left < right) {
            mid = (left + right) / 2;
            if (mountainArr[mid] < mountainArr[mid + 1]) //如果中间值小于左边第一位，peak在左边
                left = mid + 1;
            else
                right = mid - 1;
        }
        return mountainArr[left];
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 6, 4, 3, 2, 0};
        System.out.println(new FindInMountainArray().findInMountainArray(3, array));
    }
}
