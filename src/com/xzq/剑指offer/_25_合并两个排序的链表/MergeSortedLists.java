package com.xzq.剑指offer._25_合并两个排序的链表;

/**
 * @ClassName: MergeSortedLists
 * @description: 面试题25 合并两个有序的链表
 * @author: XZQ
 * @create: 2020/4/27 19:14
 **/
public class MergeSortedLists {

    public static void main(String[] args) {
        new MergeSortedLists().test1();
    }

    public void test1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode pnode1 = new ListNode(2);
        ListNode pnode2 = new ListNode(4);
        ListNode pnode3 = new ListNode(6);
        ListNode pnode4 = new ListNode(9);
        ListNode pnode5 = new ListNode(11);

        pnode1.next = pnode2;
        pnode2.next = pnode3;
        pnode3.next = pnode4;
        pnode4.next = pnode5;

        ListNode node = new MergeSortedLists().mergeByRecursive(node1, null);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public void test2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode pnode1 = new ListNode(1);
        ListNode pnode2 = new ListNode(2);
        ListNode pnode3 = new ListNode(3);
        ListNode pnode4 = new ListNode(4);
        ListNode pnode5 = new ListNode(5);

        pnode1.next = pnode2;
        pnode2.next = pnode3;
        pnode3.next = pnode4;
        pnode4.next = pnode5;

        ListNode node = new MergeSortedLists().mergeByRecursive(node1, pnode1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


    /*递归实现*/
    public ListNode mergeByRecursive(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        if (list1.val < list2.val) {
            list1.next = mergeByRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeByRecursive(list2.next, list1);
            return list2;
        }
    }

    /*非递归实现*/
    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if (list1 == null)
            p.next = list2;
        else
            p.next = list1;
        return dummyHead.next;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}