package com.xzq.leetcode._1290二进制链表转整数;

import com.xzq.剑指offer.struct.ListNode;

/**
 * @ClassName: GetDecimalValue
 * @description: leetcode 1290二进制链表转整数
 * @author: XZQ
 * @create: 2020/4/29 11:47
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 **/
public class GetDecimalValue {
    /*
     * 思路:左移
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :37.4 MB, 在所有 Java 提交中击败了5.00%的用户
     * */
    public int getDecimalValue(ListNode head) {
        if (head == null)
            return 0;
        ListNode p = head;
        int result = 0;
        while (p != null) {
            result = (result << 1) + p.val;
            p = p.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, null);
        ListNode node2 = new ListNode(0, node1);
        ListNode node3 = new ListNode(1, node2);

        System.out.println(new GetDecimalValue().getDecimalValue(node3));
    }
}
