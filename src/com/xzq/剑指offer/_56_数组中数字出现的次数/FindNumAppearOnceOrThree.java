package com.xzq.剑指offer._56_数组中数字出现的次数;

/**
 * @ClassName: FindNumAppearOnceOrThree
 * @description:
 * @author: XZQ
 * @create: 2020/5/8 8:51
 * 题目 数组除了一个数字出现一次外，其余都出现三次
 **/
public class FindNumAppearOnceOrThree {

    public int find(int[] array) {
        /*记录数组中每个数字 每一位为1的个数*/
        int[] bitSum = new int[32];
        for (int num : array) {
//            int bitMark = 1;
//            for (int j = 31; j >= 0; j--) {
//                int bit = num & bitMark;
//                if (bit != 0)
//                    bitSum[j] += 1;
//                bitMark = bitMark << 1;
//            }

            int bitIndex = 31;
            while (num != 0) {
                if ((num & 1) == 1) {
                    bitSum[bitIndex] += 1;
                }
                num = num >> 1;
                bitIndex--;
            }
        }

        /*计算结果*/
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result = bitSum[i] % 3;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] array = {1, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7};
        System.out.println(new FindNumAppearOnceOrThree().find(array));
    }
}
