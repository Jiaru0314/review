package com.xzq.剑指offer._30_包含min的最小栈;

import java.util.Stack;

/**
 * @ClassName: StackWithMin
 * @description: 面试题:30包含最小值的栈
 * @author: XZQ
 * @create: 2020/4/28 13:32
 * <p>
 * 题目
 * 　　定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)。
 * 思路
 * 　　最初想法是定义一个成员变量min来存放最小元素，但是当最小元素弹出后，min就需要相应改变，所以必须把每次的最小值都存储下来。
 * 考虑采用一个辅助栈来存放最小值：
 * 　　栈  3，4，2，5，1
 * 　  辅助栈 3， 3，2，2，1
 * 　　(压入时，把每次的最小元素（之前最小元素与新入栈元素的较小值）保存起来放到辅助栈中）
 **/
public class StackWithMin {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    /*压栈*/
    public void push1(int value) {
        if (!stack.isEmpty()) {//如果stack不为空
            int min = minStack.peek();
            if (min > value) {//如果最小栈的顶部大于value
                minStack.push(value);
            } else {
                minStack.push(min);
            }
        } else {
            minStack.push(value);
        }
        stack.push(value);
        System.out.println(min());
    }


    /*压栈 简单写法*/
    public void push(int value) {
        stack.push(value);
        if (minStack.isEmpty() || minStack.peek() > value) {
            minStack.push(value);
        } else {
            minStack.push(minStack.peek());
        }
        System.out.println(min());
    }

    /*出栈*/
    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
        System.out.println(min());
    }

    /*最小值*/
    public int min() {
        return minStack.peek();
    }


    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        stack.pop();
        stack.pop();
        stack.push(0);

    }
}
