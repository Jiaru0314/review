package com.xzq.剑指offer._20_链表中的倒数第k个节点;


import com.xzq.剑指offer.struct.ListNode;

import java.util.Stack;

/**
 * @ClassName: KthNodeFromEnd
 * @description: 面试题22: 链表中的倒数第K个节点
 * @author: XZQ
 * @create: 2020/4/27 9:27
 **/
public class KthNodeFromEnd {

    public static void main(String[] args) {
        ListNode p6 = new ListNode(6, null);
        ListNode p5 = new ListNode(5, p6);
        ListNode p4 = new ListNode(4, p5);
        ListNode p3 = new ListNode(3, p4);
        ListNode p2 = new ListNode(2, p3);
        ListNode p1 = new ListNode(1, p2);
        ListNode node = new KthNodeFromEnd().FindKthToTail2(p1, 3);
        if ((node != null)) {
            System.out.println(node.val);
        } else {
            System.out.println("test failed!");
        }

    }

    //方法1：利用栈
    public ListNode FindKthToTail1(ListNode head, int k) {
        if (head == null || k <= 0)//如果头节点为空指针或者k<=0
            return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode curNode = head;
        int listLength = 0;
        while (curNode != null) {
            listLength++;
            stack.push(curNode);
            curNode = curNode.next;
        }
        if (k > listLength) {
            return null;
        }
        for (int i = 0; i < k; i++) {
            curNode = stack.pop();
        }
        return curNode;
    }

    //方法2：利用两个指针，
    // 一个指针先向前走k-1步，第二个开始遍历，当第一个指针走到链表尾部时，第二个指针恰好在倒数第k个节点
    public ListNode FindKthToTail2(ListNode head, int k) {
        if (head == null || k <= 0)//如果头节点为空指针或者k<=0
            return null;
        ListNode node1 = head;
        ListNode node2 = null;
        /*node1先向前走k-1步*/
        for (int i = 0; i < k - 1; i++) {
            if (node1.next != null) {
                node1 = node1.next;
            } else {
                return null;
            }
        }
        node2 = head;
        while (node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node2;
    }
}
