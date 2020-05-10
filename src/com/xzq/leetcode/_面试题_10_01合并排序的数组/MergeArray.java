package com.xzq.leetcode._面试题_10_01合并排序的数组;

import com.xzq.algorithm.sort.ArrayUtil;

import java.util.Arrays;

/**
 * @ClassName: MergeArray
 * @description: 合并排序的数组
 * @author: XZQ
 * @create: 2020/5/3 13:02
 * https://leetcode-cn.com/problems/sorted-merge-lcci/
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 **/
public class MergeArray {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 0, 0, 0};
        int[] B = {2, 5, 6};
        new MergeArray().merge(A, 3, B, 3);
        ArrayUtil.printArray(A);
    }

    public void merge(int[] A, int m, int[] B, int n) {
        int currIndex = m + n - 1;
        int aIndex = m - 1;
        int bIndex = n - 1;

        while (currIndex >= 0) {
            if (aIndex >= 0 && bIndex >= 0) {//确保其中一个数组遍历完
                A[currIndex--] = A[aIndex] > B[bIndex] ? A[aIndex--] : B[bIndex--];
            } else if (aIndex < 0) {//如果A遍历完毕 B没有遍历完毕 继续将B剩余的拷贝到A中
                A[currIndex--] = B[bIndex--];
            } else {//B遍历完毕 A没有遍历完毕 A中顺序已经有序 退出
                break;
            }
        }
    }
}
