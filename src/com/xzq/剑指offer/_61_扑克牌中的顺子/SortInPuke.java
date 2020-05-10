package com.xzq.剑指offer._61_扑克牌中的顺子;

import java.util.HashSet;

/**
 * @ClassName: SortInPuke
 * @description: 扑克牌中的顺子
 * @author: XZQ
 * @create: 2020/5/9 11:49
 **/
public class SortInPuke {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 12, 0, 3};
        System.out.println(new SortInPuke().isSort(nums));
        System.out.println(new SortInPuke().isSort2(nums));
    }

    public boolean isSort(int[] nums) {
        if (nums == null || nums.length < 5)
            return false;
        //先对数组进行排序
        quickSort(nums, 0, nums.length - 1);
        int numsOfZero = 0;
        int numsOfGap = 0;

        //找出排序后数组中 相邻两个数有空格的个数 以及数组中是0的个数
        for (int i = 0; i <= nums.length - 2; i++) {
            if (nums[i] == 0) {//等于0
                numsOfZero++;
            } else {//不等于0
                if (nums[i] == nums[i + 1])
                    return false;
                else {
                    numsOfGap += nums[i + 1] - nums[i] - 1;
                }
            }
        }
        System.out.println(numsOfGap);
        return numsOfGap <= numsOfZero;
    }

    /*快速排序*/
    public int getIndex(int[] nums, int start, int end) {
        int temp = nums[start];

        while (start < end) {
            while (end > start && nums[end] >= temp)
                end--;
            nums[start] = nums[end];
            while (end > start && nums[start] <= temp)
                start++;
            nums[end] = nums[start];
        }
        nums[start] = temp;
        return start;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int index = getIndex(nums, start, end);
            quickSort(nums, start, index - 1);
            quickSort(nums, index + 1, end);
        }
    }


    public boolean isSort2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int min = 13;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != 0) {
                //判断是否重复
                if (set.contains(num))
                    return false;
                set.add(num);
                //不重复
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
        }
        return max - min < 5;
    }
}
