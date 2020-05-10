package com.xzq.剑指offer._62_圆圈中剩下的数字;

import com.xzq.剑指offer.struct.ListNode;
import com.xzq.剑指offer.utils.ListNodeUtils;

/**
 * @ClassName: LastRemaining
 * @description:
 * @author: XZQ
 * @create: 2020/5/8 16:14
 **/
public class LastRemaining {

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        LastRemaining lastRemaining = new LastRemaining();
        ListNode listNode = lastRemaining.bulidNode(array);
        lastRemaining.getLast(listNode);

    }

    public void getLast(ListNode head) {
        int count = 3;
        ListNode p = head;
        while (p.next != p) {
            for (int i = 1; i < count; i++) {
                p = p.next;
            }
            System.out.println(p.next.val);
            p.next = p.next.next;
        }
        System.out.println("幸运者是： " + p.val);
    }

    /*构建循环链表*/
    public ListNode bulidNode(int[] array) {
        ListNode head = new ListNode(array[0], null);
        ListNode p = head;
        for (int i = 1; i < array.length; i++) {
            ListNode node = new ListNode(array[i]);
            p.next = node;
            p = node;
        }
        //尾指针指向头指针
        p.next = head;
        return head;
    }
}
