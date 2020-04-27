package com.xzq.剑指offer;

import java.util.Stack;

/**
 * @ClassName: PrintListInReversedOrder
 * @description: 从尾到头输出链表的值
 * @author: XZQ
 * @create: 2020/4/25 16:12
 **/
public class PrintListInReversedOrder {
    public static void main(String[] args) {
        PrintListInReversedOrder demo = new PrintListInReversedOrder();
        System.out.println("test1:");
        demo.test1();
        System.out.println("test2:");
        demo.test2();
        System.out.println("test3:");
        demo.test3();
    }

    /*采用栈的方式*/
    public void printListReversingly_Iteratively(Node node) {
        Stack<Node> nodeStack = new Stack<>();
        while (node != null) {
            nodeStack.push(node);
            node = node.next;
        }
        while (!nodeStack.empty()) {
            System.out.println(nodeStack.pop().val);
        }
    }

    /*采用递归的方式*/
    public void printListReversingly_Recursively(Node node) {
        if (node != null) {
            printListReversingly_Recursively(node.next);
            System.out.println(node.val);
        } else {
            return;
        }
    }

    /*递归第二种写法*/
    public void printListReversingly_Recursively2(Node node) {
        if (node != null) {
            if (node.next != null) {
                printListReversingly_Recursively2(node.next);
            }
            System.out.println(node.val);
        }
    }

    // ==================================测试代码==================================

    /**
     * 链表为空
     */
    public void test1() {
        Node aNode = null;
        System.out.println("采用栈：");
        printListReversingly_Iteratively(aNode);
    }

    /**
     * 多个结点链表
     */
    public void test2() {
        Node Node1 = new Node(1);
        Node Node2 = new Node(2);
        Node Node3 = new Node(3);
        Node Node4 = new Node(4);
        Node Node5 = new Node(5);
        Node1.next = Node2;
        Node2.next = Node3;
        Node3.next = Node4;
        Node4.next = Node5;
        System.out.println("采用栈：");
        printListReversingly_Iteratively(Node1);
        System.out.println("采用递归：");
        printListReversingly_Recursively(Node1);
    }

    /**
     * 单个结点链表
     */
    public void test3() {
        Node Node1 = new Node(1);
        System.out.println("采用栈：");
        printListReversingly_Iteratively(Node1);
    }


}

class Node {
    int val;
    Node next = null;

    public Node(int val) {
        this.val = val;
    }
}