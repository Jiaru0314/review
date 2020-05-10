package com.xzq.leetcode._125_验证回文串;

/**
 * @ClassName: ValidPalindrome
 * @description:
 * @author: XZQ
 * @create: 2020/5/8 18:56
 **/
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindrome("a."));
    }

    public boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;
        String str = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
