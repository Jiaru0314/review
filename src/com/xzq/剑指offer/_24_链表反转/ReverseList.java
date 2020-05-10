package com.xzq.剑指offer._24_链表反转;

/**
 * @ClassName: ReverseList
 * @description:面试题24 链表反转
 * @author: XZQ
 * @create: 2020/4/27 17:31
 * 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链头结点。
 **/
public class ReverseList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node = new ReverseList().resverse(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


    /*三个指针实现*/
    public ListNode resverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode curNode = head;//当前节点
        ListNode preNode = null;//前一个节点
        ListNode nextNode = curNode.next;//后一个节点

        while (nextNode != null) {
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
            nextNode = curNode.next;
        }
        curNode.next = preNode;
        return curNode;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/*
* 收获
　　1.递归还是不够熟悉，第一反应想到的还是非递归实现。注意每次操作相同时，要立即考虑到可以采用递归来进行实现。
　　2.递归实现时，需要注意链接的问题。
* */