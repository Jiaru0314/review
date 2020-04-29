package com.xzq.leetcode._1021删除最外层的括号;

import java.io.RandomAccessFile;
import java.util.Stack;

/**
 * @ClassName: RemoveOuterParentheses
 * @description: leetcode1021 删除最外层的括号
 * @author: XZQ
 * @create: 2020/4/29 10:22
 * 输入："(()())(())"
 * 输出："()()()"
 * https://leetcode-cn.com/problems/remove-outermost-parentheses/
 **/
public class RemoveOuterParentheses {

    /*耗时12ms 内存40MB*/
    public String removeOuterParentheses(String S) {
        if (S.length() <= 0)
            return "";
        StringBuilder stringBuilder = new StringBuilder();
        int start = 0;
        int end = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(')
                stack.push('(');
            else
                stack.pop();
            if (stack.isEmpty()) {
                end = i;
                stringBuilder.append(S, start + 1, end);
                start = end + 1;
            }
        }
        return stringBuilder.toString();
    }

    /*耗时6ms 内存40MB*/
    public String removeOuterParentheses2(String S) {
        if (S.length() <= 0)
            return "";
        int num = 0;
        int start = 0;
        int end = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(')
                num++;
            else
                num--;
            if (num == 0) {
                end = i;
                stringBuilder.append(S, start + 1, end);
                start = end + 1;
            }
        }
        return stringBuilder.toString();
    }

    /*耗时3ms 内存40MB*/
    public String removeOuterParentheses3(String S) {
        if (S.length() <= 0)
            return "";
        StringBuilder s = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')')
                level--;
            if (level >= 1)
                s.append(c);
            if (c == '(')
                level++;
        }
        return s.toString();
    }


    public static void main(String[] args) {
        System.out.println(new RemoveOuterParentheses().removeOuterParentheses2("(()())(())"));
        System.out.println(new RemoveOuterParentheses().removeOuterParentheses2("(()())(())(()(()))"));
        System.out.println(new RemoveOuterParentheses().removeOuterParentheses2("()()"));
    }
}
