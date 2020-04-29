package com.xzq.leetcode._237_删除链表中的节点;

import com.xzq.剑指offer.struct.ListNode;

/**
 * @ClassName: DeleteNode
 * @description: leetcode 237_删除链表中的节点
 * @author: XZQ
 * @create: 2020/4/29 13:16
 * 题目:请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 **/
public class DeleteNode {

    /*思路：将下一个节点的值复制到当前节点，删除下一个节点*/
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
