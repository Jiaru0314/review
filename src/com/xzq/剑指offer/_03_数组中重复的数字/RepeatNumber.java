package com.xzq.剑指offer._03_数组中重复的数字;

/**
 * @ClassName: RepeatNumber
 * @description: 剑指Offer 面试题3
 * @author: XZQ
 * @create: 2020/5/5 20:46
 **/
public class RepeatNumber {
    public static void main(String[] args) {
        System.out.println(new RepeatNumber().checkRepeat(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println(new RepeatNumber().checkRepeat(new int[]{2, 3, 1, 0, 4, 5, 6}));
        System.out.println(new RepeatNumber().checkRepeat(new int[]{-1}));

        System.out.println(new RepeatNumber().findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(new RepeatNumber().findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }

    public boolean checkRepeat(int[] array) {
        if (array == null || array.length <= 0)
            return false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0 || array[i] >= array.length)
                return false;
        }
        for (int i = 0; i < array.length; i++) {
            while (array[i] != i) {
                if (array[i] == array[array[i]])
                    return true;

                int temp = array[array[i]];
                array[array[i]] = array[i];
                array[i] = temp;
            }
        }
        return false;
    }


    /*leetcode 287*/
    public int findDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1])
                    return nums[i];

                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        return 0;
    }
}
