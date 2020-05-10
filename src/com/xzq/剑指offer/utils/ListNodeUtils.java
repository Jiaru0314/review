package com.xzq.剑指offer.utils;

import com.xzq.剑指offer.struct.ListNode;

/**
 * @ClassName: ListNodeUtils
 * @description:
 * @author: XZQ
 * @create: 2020/5/6 11:19
 **/
public class ListNodeUtils {
    public static void printNode(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
