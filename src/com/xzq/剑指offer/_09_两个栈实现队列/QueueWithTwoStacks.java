package com.xzq.剑指offer._09_两个栈实现队列;

import java.util.Stack;

/**
 * @ClassName: QueueWithTwoStacks
 * @description: 第7题：用两个栈实现队列
 * @author: XZQ
 * @create: 2020/4/26 8:38
 * <p>
 * 题目
 * 　　用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead，
 * 分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 * <p>
 * 思路
 * 　　这道题较简单，自己先试着模拟一下插入删除的过程（在草稿纸上动手画一下）：插入肯定是往一个栈stack1中一直插入；
 * 删除时，直接出栈无法实现队列的先进先出规则，这时需要将元素从stack1出栈，压到另一个栈stack2中，然后再从stack2中出栈就OK了。
 * 需要稍微注意的是：当stack2中还有元素，stack1中的元素不能压进来；
 * 当stack2中没元素时，stack1中的所有元素都必须压入stack2中。否则顺序就会被打乱。
 *
 * 测试用例
 * 　　1.往空队列添加删除元素
 * 　　2.往非空队列添加删除元素
 * 　　3.删除至队列为空
 **/
public class QueueWithTwoStacks {
    public static void main(String[] args) {
        QueueWithTwoStacks demo = new QueueWithTwoStacks();
        demo.test1();
        demo.test2();
    }

    //=======测试代码==========

    public void test1() {
        Queue queue = new Queue();
        queue.appendTail(1);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }

    /**
     * 从空队列删除元素
     */
    public void test2() {
        Queue queue = new Queue();
        System.out.println(queue.deleteHead());
    }
}

class Queue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void appendTail(Integer node) {
        stack1.push(node);
    }

    public int deleteHead() {
        //如果stack2为空
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {//如果stack1为空
                throw new RuntimeException("队列为空");
            } else {//stack1不为空
                while (!stack1.isEmpty()) {//将stack1中的元素全部压入stack2中
                    stack2.push(stack1.pop());
                }
            }
        }
        return stack2.pop();
    }
}

/*
* 收获
　　1.学会用画图将抽象问题形象化
* */