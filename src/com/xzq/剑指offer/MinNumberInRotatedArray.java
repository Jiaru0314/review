package com.xzq.剑指offer;

/**
 * @ClassName: MinNumberInRotatedArray
 * @description: 第八题：旋转数组中最小的数字
 * @author: XZQ
 * @create: 2020/4/26 10:48
 * <p>
 * 题目
 * 　　把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组{3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。
 * <p>
 * <p>
 * 思路
 * 　　数组在一定程度上是排序的，很容易分析出：可以采用二分法来寻找最小数字。
 * 　　但是这里面有一些陷阱：
 * 　　1.递增排序数组的本身是自己的旋转，则最小数字是第一个数字
 * 　　2.中间数字与首尾数字大小相等，如{1,0,1,1,1,1}和{1,1,1,1,0,1}，无法采用二分法，只能顺序查找。
 * 测试用例
 * 　　1.功能测试（正常旋转数组，中间有或者无重复数字）
 * 　　2.边界值测试（升序数组，1个数字的数组）
 * 　　3.特殊输入测试（null，空数组）
 **/
public class MinNumberInRotatedArray {
    public int minNumberInRotateArray(int[] array) {
        if (null == array || array.length <= 0)//空数组或null返回0
            return 0;
        int start = 0;
        int last = array.length - 1;
        int mid = (start + last) / 2;
        //如果是升序数组
        if (array[start] < array[last]) {
            return array[start];
        }

        //中间数字与首尾数字相等
        if (array[mid] == array[last] && array[mid] == array[start]) {
            for (int i = 1; i <= last; i++) {
                if (array[i] < array[i - 1])
                    return array[i];
            }
            return array[start];
        }
        //正常情况
        while (start < last) {
            if (last - start == 1)
                break;
            mid = (start + last) / 2;
            if (array[mid] > array[start])//中间值大于
                start = mid;
            if (array[mid] < array[start])
                last = mid;
        }
        return array[last];
    }

    // =======测试代码======
    public void test1() {
        int[] array = null;
        System.out.println("test1:" + minNumberInRotateArray(array));
    }

    public void test2() {
        int[] array = {};
        System.out.println("test2:" + minNumberInRotateArray(array));
    }

    public void test3() {
        int[] array = {1};
        System.out.println("test3:" + minNumberInRotateArray(array));
    }

    public void test4() {
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println("test4:" + minNumberInRotateArray(array));
    }

    public void test5() {
        int[] array = {2, 2, 2, 2, 1, 2};
        System.out.println("test5:" + minNumberInRotateArray(array));
    }

    public void test6() {
        int[] array = {2, 1, 2, 2, 2, 2};
        System.out.println("test6:" + minNumberInRotateArray(array));
    }

    public void test7() {
        int[] array = {6, 6, 8, 9, 10, 1, 2, 2, 3, 3, 4, 5, 6};
        System.out.println("test7:" + minNumberInRotateArray(array));
    }

    public static void main(String[] args) {
        MinNumberInRotatedArray demo = new MinNumberInRotatedArray();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
    }
}


/*
* 收获
　　1.对于一些涉及数组的方法（如二分法等），可以用low和high，mid等来定义下标，
*       但是，输出时如果要求输出数据值array[low]，不要错写成下标low了。
　　2.思维一定要考虑全面，特别是接触到一个新的概念时，要注意到一些特例，如递增排序数组的本身是自己的旋转、相同数字数组等。
* */
