package com.xzq.leetcode._1013_将数组分为和相等的三个部分;

/**
 * @ClassName: PartitionArrayIntoThreeParts
 * @description: 将数组分为和相等的三个部分
 * @author: XZQ
 * @create: 2020/5/9 16:59
 **/
public class PartitionArrayIntoThreeParts {

    public static void main(String[] args) {
        int[] array2 = {14, 6, -10, 2, 18, -7, -4, 11};
        System.out.println(new PartitionArrayIntoThreeParts().canThreePartsEqualSum(array2));
    }

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }

        if (sum % 3 != 0)
            return false;

        int num = sum / 3;
        int left = 0;
        int right = A.length - 1;

        int lSum = A[left];
        int rSum = A[right];
        while (right - left > 1) {
            if (lSum == num && lSum == num) {
                System.out.println("right:" + right + " left " + left);
                return true;
            }

            if (lSum != num)
                lSum += A[++left];

            if (rSum != num)
                rSum += A[--right];
        }
        return false;
    }
}
