package com.xzq.剑指offer._58_翻转字符串;

/**
 * @ClassName: ReverseString
 * @description:
 * @author: XZQ
 * @create: 2020/5/8 10:35
 **/
public class ReverseString {

    public static void main(String[] args) {

        System.out.println(new ReverseString().reverse("hello wang lei"));
    }

    public String reverse(String str) {
        char[] chars = str.toCharArray();//字符串转成字符数组
        swap(chars, 0, chars.length - 1);//

        int left = 0;
        int right = 0;
        for (char ch : chars) {
            if (ch != ' ') {
                right++;
            } else {
                swap(chars, left, right - 1);
                left = right + 1;
                right = left;
            }
        }
        return new String(chars);
    }

    /*单个字符串反转*/
    private void swap(char[] ch, int begin, int last) {
        while (begin < last) {
            char temp = ch[last];
            ch[last--] = ch[begin];
            ch[begin++] = temp;
        }
    }
}