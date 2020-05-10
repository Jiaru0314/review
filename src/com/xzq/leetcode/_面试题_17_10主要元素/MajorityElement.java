package com.xzq.leetcode._面试题_17_10主要元素;

/**
 * @ClassName: MajorityElement
 * @description:
 * @author: XZQ
 * @create: 2020/4/30 18:09
 **/
public class MajorityElement {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 9, 5, 9, 5, 5, 5};
        System.out.println(new MajorityElement().majorityElement(array));
    }

    /*摩尔投票算法+验证*/
    public int majorityElement(int[] nums) {
        int count = 1;
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (temp == nums[i])
                count++;
            else
                count--;
            if (count == 0) {
                temp = nums[i];
                count = 1;
            }
        }

        int t = nums.length / 2 + 1;//半数+1
        for (int i : nums) {
            if (temp == i)
                t--;
            if (t == 0)
                return temp;
        }
        return -1;
    }
}
