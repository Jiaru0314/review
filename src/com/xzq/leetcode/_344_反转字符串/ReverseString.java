package com.xzq.leetcode._344_反转字符串;

/**
 * @ClassName: ReverseString
 * @description:
 * @author: XZQ
 * @create: 2020/5/8 10:49
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 **/
public class ReverseString {

    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        new ReverseString().reverseString(chars);
    }

    /*双指针 时间复杂度 O(n) 空间复杂度O(1)*/
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
