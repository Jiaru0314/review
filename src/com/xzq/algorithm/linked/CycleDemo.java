package com.xzq.algorithm.linked;

/**
 * @ClassName: CycleDemo
 * @description: 判断链表是否有环 两个指针 一个每次向后移动一步 一个每次向后移动两步
 * @author: XZQ
 * @create: 2020/4/11 17:22
 **/
public class CycleDemo {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        System.out.println("是否是有环链表" + isCycle(node1));
    }

    public static boolean isCycle(Node head) {
        Node p1 = head;
        Node p2 = head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

}
