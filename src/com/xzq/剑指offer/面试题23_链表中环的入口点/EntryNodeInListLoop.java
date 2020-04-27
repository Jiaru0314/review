package com.xzq.剑指offer.面试题23_链表中环的入口点;

/**
 * @ClassName: EntryNodeInListLoop
 * @description: 链表中环的入口点
 * @author: XZQ
 * @create: 2020/4/27 15:10
 * <p>
 * 题目
 * 　　一个链表中包含环，如何找出环的入口结点？例如，在图3.8的链表中，环的入口结点是结点3。
 * 思路
 * 　　1.确定链表是否有环：通过两个不同速度的指针确定，当两个指针指向同一个结点时，该结点为环中的一个结点。
 * 　　2.确定环中结点的数目n：指针走一圈，边走边计数
 * 　　3.找到环的入口：从头结点开始，通过两个相差为n的指针来得到（即寻找链表中倒数第n个结点）
 * 　　更简单的思路：【LeetCode】142. Linked List Cycle II
 **/
public class EntryNodeInListLoop {
    /*
     * 确定链表是否有环，采用快慢指针确定
     * 返回值代表快慢指针相遇时的结点，返回null代表链表无环
     */
    private ListNode meetingNode(ListNode head) {

        ListNode pSlow = head;//慢指针
        ListNode pFast = head;//快指针

        while (pFast != null && pFast.next != null) {
            pFast = pFast.next.next;//快指针每次移动两个Node
            pSlow = pSlow.next;
            if (pFast == pSlow) {//如果相遇，返回相遇点，相遇点一定在环中
                return pFast;
            }
        }
        return null;
    }


    /**
     * 计算环中入口结点
     */
    public ListNode entryNodeOfLoop(ListNode head) {
        /*先找到环的长度 从相遇点开始循环直到下次到达相遇点即环长*/
        ListNode meetingNode = meetingNode(head);

        int length = 1;
        ListNode node = meetingNode.next;
        if (meetingNode != null) {
            while (node != meetingNode) {
                length++;
                node = node.next;
            }
        }

        /*从头结点开始，通过两个相差为环长length的指针来得到入环点*/
        ListNode node2 = head;
        for (int i = 0; i < length; i++) {
            node2 = node2.next;
        }
        node = head;
        while (node != node2) {
            node = node.next;
            node2 = node2.next;
        }
        return node;
    }


    /*解法2：
    the distance between the head node and entry node equals the distance between the meeting node and entry node;*/

    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;
        ListNode entry = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {//相遇
                while (slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
    }


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
        node5.next = node2;

        EntryNodeInListLoop entryNodeInListLoop = new EntryNodeInListLoop();

        ListNode node = entryNodeInListLoop.meetingNode(node1);
        System.out.println("是否是有环链表: "
                + (node == null ? "False" : "Yes,the node is :" + node.val + "入环点是"
                + entryNodeInListLoop.entryNodeOfLoop(node1).val));
        System.out.println(entryNodeInListLoop.detectCycle(node1).val);
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
　　1.通过两个不同速度的指针可以确定链表中是否有环
　　2.相差n步的两个指针可以找到倒数第n个结点（链表中倒数第k个结点）
　　3.复杂问题分解成为几个简单问题（本题分为三步：找出环中任一结点；得到环的个数；找到入口结点）
* */