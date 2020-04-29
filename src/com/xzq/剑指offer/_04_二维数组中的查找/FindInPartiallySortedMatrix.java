package com.xzq.剑指offer._04_二维数组中的查找;

/**
 * @ClassName: FindInPartiallySortedMatrix
 * @description: 二维数组查找
 * @author: XZQ
 * @create: 2020/4/15 11:43
 * <p>
 * <p>
 * 题目:
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 参考：https://www.cnblogs.com/edisonchou/p/4737944.html
 **/
public class FindInPartiallySortedMatrix {

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}, {6, 8, 11, 15}};
        System.out.println(new FindInPartiallySortedMatrix().Find(6, array));
    }

    /*解题思路：从右上角开始查找。
    如果当前值等于target，则返回。
    如果当前值小于target，那么column++,向下查找。
    如果当前值大于target,那么row--,向左查找。
    这样，每一次比较都可以剔除一行或者一列，进而缩小查找范围，时间复杂度为O(n)。
    */
    public boolean Find(int target, int[][] array) {
        int rows = array.length;//获取数组行数
        int columns = array[0].length;//获取数组列数

        //判断二维数组不为空
        if (null != array && rows > 0 && columns > 0) {
            int row = 0;//从第一行开始
            int column = columns - 1;//从最后一列开始
            //行:从上到下，列:从右到左
            while (row < rows && column >= 0) {
                //如果当前位置值等于target,返回true
                if (target == array[row][column]) {
                    return true;
                }
                //如果当前位置值大于target,column--
                if (target < array[row][column]) {
                    column--;
                }
                //如果当前位置值小于target,row++
                if (target > array[row][column]) {
                    row++;
                }
            }
        }
        return false;
    }
}

/*
 * 在前面的分析中，我们每一次都是选取数组查找范围内的右上角数字。
 * 同样，我们也可以选取左下角的数字。但我们不能选择左上角或者右下角。
 * 以左上角为例，最初数字1位于初始数组的左上角，由于1小于7，那么7应该位于1的右边或者下边。
 * 此时我们既不能从查找范围内剔除1所在的行，也不能剔除1所在的列，这样我们就无法缩小查找的范围。
 */