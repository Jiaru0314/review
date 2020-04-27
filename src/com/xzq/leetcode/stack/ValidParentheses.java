package com.xzq.leetcode.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @ClassName: ValidParentheses
 * @description:leetcode20 有效的括号
 * @author: XZQ
 * @create: 2020/4/26 18:35
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class ValidParentheses {
    public static void main(String[] args) {
        String str = "[{()}]";
        String str1 = "()[]";
        System.out.println(new ValidParentheses().isValid3(str));
        System.out.println(new ValidParentheses().isValid3(str1));
    }

    /*使用栈*/
    public boolean isValid(String s) {
        if (s == null)
            return false;
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(' || charArray[i] == '{' || charArray[i] == '[') {//如果是左括号,压栈
                stack.push(charArray[i]);
            } else {//如果是右括号
                if (stack.isEmpty())//特殊判断
                    return false;
                Character topChar = stack.peek();
                if (topChar == '(' && charArray[i] == ')') {
                    stack.pop();
                } else if (topChar == '{' && charArray[i] == '}') {
                    stack.pop();
                } else if (topChar == '[' && charArray[i] == ']') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /*字符串替换+递归 实现简单时间复杂度高*/
    public boolean isValid2(String str) {
        if (str.contains("()") || str.contains("{}") || str.contains("[]")) {
            return isValid(str.replace("()", "").replace("{}", "").replace("[]", ""));
        } else {
            return "".equals(str);
        }
    }

    /*第一种方式改良版本 栈+HashMap 时间复杂度O(n) 空间复杂度O(n)*/
    public boolean isValid3(String s) {
        if (s == null)
            return false;

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}