package com.xzq.leetcode._234回文链表;

import com.xzq.剑指offer.struct.ListNode;

/**
 * @ClassName: PalindromeLinkedList
 * @description:
 * @author: XZQ
 * @create: 2020/5/6 10:57
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 **/
public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(new PalindromeLinkedList().isPalindrome(node1));
    }

    /*判断是否是回文链表*/
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        ListNode node = head;
        ListNode mid = endOfFirstHalf(head);
        ListNode node2 = resverse(mid);
        while (node != null && node2 != null) {
            if (node2.val != node.val) {
                return false;
            }
            node = node.next;
            node2 = node2.next;
        }
        return true;
    }

    /*找到中间节点*/
    public ListNode endOfFirstHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return (fast != null) ? slow.next : slow;
    }

    /*反转链表*/
    public ListNode resverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;

        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        return cur;
    }
}
