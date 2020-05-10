package com.xzq.leetcode._160_相交链表;

import com.xzq.剑指offer.struct.ListNode;

/**
 * @ClassName: IntersectionNode
 * @description: 相交链表
 * @author: XZQ
 * @create: 2020/5/1 16:21
 **/
public class IntersectionNode {
    public static void main(String[] args) {
        ListNode listNode55 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode55);
        ListNode listNode8 = new ListNode(8, listNode4);
        ListNode listNode1 = new ListNode(1, listNode8);
        ListNode listNode0 = new ListNode(0, listNode1);
        ListNode listNode5 = new ListNode(5, listNode0);

        ListNode listNode11 = new ListNode(1, listNode8);
        ListNode listNode44 = new ListNode(4, listNode11);


        System.out.println(new IntersectionNode().getIntersectionNode2(listNode44, listNode5).val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getListLength(headA);
        int lenB = getListLength(headB);
        ListNode pA = headA;
        ListNode pB = headB;
        int k;
        if (lenA > lenB) {
            k = lenA - lenB;
            for (int i = 0; i < k; i++) {
                pA = pA.next;
            }
        } else {
            k = lenB - lenA;
            for (int i = 0; i < k; i++) {
                pB = pB.next;
            }
        }

        while (pA != null) {
            if (pA == pB)
                return pA;
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }

    private int getListLength(ListNode head) {
        if (head == null)
            return 0;
        int count = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    private int getListLength(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        int len = 0;
        boolean temp = false;
        while (pA != null || pB != null) {
            if (pA == pB) {
                temp = true;
            }
            if (temp) {
                len++;
            }
        }
        return len;
    }

    /*
     * 定义两个指针pA,pB，分别指向headA,headB
     * 同时向后遍历。
     * 当pA==null时 pA= headB
     * 当pB==null时 pB= headA
     * 再次遍历 如果pA == pB 两种情况 找到交点 无交点 null
     * */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode pA = headA, pB = headB;

        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
