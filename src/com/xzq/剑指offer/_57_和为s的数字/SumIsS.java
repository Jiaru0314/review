package com.xzq.剑指offer._57_和为s的数字;

/**
 * @ClassName: SumIsS
 * @description: 和为s的数字
 * @author: XZQ
 * @create: 2020/5/8 9:50
 * 递增排序的数组和一个数字target,找出和为target的两个数，如果有多对，只输出一对
 **/
public class SumIsS {

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 11, 15};
        System.out.println(new SumIsS().findNumWithSum(array, 15));
    }

    public boolean findNumWithSum(int[] array, int target) {
        if (array == null || array.length < 2 || target < array[0])
            return false;

        int startIndex = 0;
        int lastIndex = array.length - 1;
        while (startIndex < lastIndex) {
            int temp = array[startIndex] + array[lastIndex];
            if (temp == target) {
                System.out.println("The num is " + array[startIndex] + " " + array[lastIndex]);
                return true;
            } else if (temp < target) {//如果和小于目标值
                startIndex++;
            } else {//和大于目标值
                lastIndex--;
            }
        }
        return false;
    }
}
