package com.xzq.剑指offer;

/**
 * @ClassName: DeleteDuplicatedNode
 * @description: 删除重复的链表节点
 * @author: XZQ
 * @create: 2020/4/26 16:50
 * 题目
 * 　　在一个排序的链表中，如何删除重复的结点？例如，在图3.4（a）中重复结点被删除之后，链表如图3.4（b）所示。
 **/
public class DeleteDuplicatedNode {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {//空节点或仅有一个节点
            return pHead;
        }

        ListNode preNode = null;
        ListNode curNode = pHead;
        while (curNode != null) {//如果当前节点不为null
            boolean needDelete = false;
            if (curNode.next != null && curNode.val == curNode.next.val) {//如果当前节点的下个节点不为null并且当前节点的值和下个节点值相同
                needDelete = true;
            }
            if (!needDelete) {//当前节点不重复
                preNode = curNode;
                curNode = curNode.next;
            } else {//重复
                int dupValue = curNode.val;
                ListNode toBeDelete = curNode.next;
                while (toBeDelete != null && toBeDelete.val == dupValue) {
                    toBeDelete = toBeDelete.next;
                }
                if (preNode == null) {//说明删除的是头节点
                    pHead = toBeDelete;
                } else {
                    preNode.next = toBeDelete;
                }
                curNode = toBeDelete;
            }
        }
        return pHead;
    }

    //========测试代码======
    void test(ListNode pHead) {
        System.out.println("-----------");
        System.out.print("The original list is: ");
        ListNode curr = pHead;
        if (curr != null) {
            while (curr.next != null) {
                System.out.print(curr.val + ",");
                curr = curr.next;
            }
            System.out.println(curr.val);
        } else {
            System.out.println();
        }
        pHead = deleteDuplication(pHead);
        System.out.print("The result list is: ");
        curr = pHead;
        if (curr != null) {
            while (curr.next != null) {
                System.out.print(curr.val + ",");
                curr = curr.next;
            }
            System.out.println(curr.val);
        } else {
            System.out.println();
        }
        System.out.println("-----------");
    }


    /**
     * 重复结点位于链表头部
     */
    void test1() {
        ListNode p4 = new ListNode(3, null);
        ListNode p3 = new ListNode(2, p4);
        ListNode p2 = new ListNode(1, p3);
        ListNode p1 = new ListNode(1, p2);
        test(p1);
    }

    /**
     * 重复结点位于链表尾部
     */
    void test2() {
        ListNode p4 = new ListNode(3, null);
        ListNode p3 = new ListNode(3, p4);
        ListNode p2 = new ListNode(2, p3);
        ListNode p1 = new ListNode(1, p2);
        test(p1);
    }

    /**
     * 重复结点位于链表中部
     */
    void test3() {
        ListNode p4 = new ListNode(3, null);
        ListNode p3 = new ListNode(2, p4);
        ListNode p2 = new ListNode(2, p3);
        ListNode p1 = new ListNode(1, p2);
        test(p1);
    }

    /**
     * 连续出现重复结点
     */
    void test4() {
        ListNode p6 = new ListNode(3, null);
        ListNode p5 = new ListNode(3, p6);
        ListNode p4 = new ListNode(2, p5);
        ListNode p3 = new ListNode(2, p4);
        ListNode p2 = new ListNode(1, p3);
        ListNode p1 = new ListNode(1, p2);
        test(p1);
    }

    /**
     * 多个重复结点
     */
    void test5() {
        ListNode p6 = new ListNode(3, null);
        ListNode p5 = new ListNode(3, p6);
        ListNode p4 = new ListNode(3, p5);
        ListNode p3 = new ListNode(2, p4);
        ListNode p2 = new ListNode(1, p3);
        ListNode p1 = new ListNode(1, p2);
        test(p1);
    }

    /**
     * 无重复结点
     */
    void test6() {
        ListNode p6 = new ListNode(6, null);
        ListNode p5 = new ListNode(5, p6);
        ListNode p4 = new ListNode(4, p5);
        ListNode p3 = new ListNode(3, p4);
        ListNode p2 = new ListNode(2, p3);
        ListNode p1 = new ListNode(1, p2);
        test(p1);
    }

    /**
     * 单个结点
     */
    void test7() {
        ListNode p1 = new ListNode(6, null);
        test(p1);
    }

    /**
     * null
     */
    void test8() {
        ListNode p1 = null;
        test(p1);
    }

    public static void main(String[] args) {
        DeleteDuplicatedNode demo = new DeleteDuplicatedNode();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
        demo.test8();
    }

}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}