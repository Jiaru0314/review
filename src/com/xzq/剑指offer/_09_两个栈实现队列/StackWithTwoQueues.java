package com.xzq.剑指offer._09_两个栈实现队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: StackWithTwoQueues
 * @description: 第七题延申:两个队列实现一个栈
 * @author: XZQ
 * @create: 2020/4/26 9:08
 **/
public class StackWithTwoQueues {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

class MyStack {
    private Queue<Integer> queue1 = new LinkedList<>();//Queue是接口，不能直接实例化
    private Queue<Integer> queue2 = new LinkedList<>();

    /*入栈*/
    public void push(int item) {
        //如果两个队列都为空，优先选择queue1来添加元素
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.add(item);
            return;
        }
        //如果queue1为空，向queue2添加元素
        if (queue1.isEmpty()) {
            queue2.add(item);
        } else {
            queue1.add(item);
        }
    }

    /*出栈*/
    public int pop() {
        //如果两个队列都为空
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new RuntimeException("栈为空");
        }

        //如果queue2为空，将queue1的前queue1.size()-1个元素弹出放入queue2队列，queue1的最后一个元素直接弹出
        if (queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }
        //如果queue1为空，将queue2的前queue2.size()-1个元素弹出放入queue1队列，queue2的最后一个元素直接弹出
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }
        return 0;
    }
}