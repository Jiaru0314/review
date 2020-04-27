package com.xzq.algorithm.linked;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

/**
 * @ClassName: MyLinkedList
 * @description:
 * @author: XZQ
 * @create: 2020/4/16 8:49
 **/
public class MyLinkedList {
    private Node head;
    private int size;
    private Node last;

    /**
     * 删除链表元素
     *
     * @param index 删除元素的位置
     * @return
     */
    public Node remove(int index) {
        rangeCheckForAdd(index);
        Node removeNode = null;

        if (index == 0) {
            //删除头节点
            removeNode = head;
            head = head.next;
        } else if (index == size - 1) {
            //删除尾节点
            Node preNode = get(index - 1);
            removeNode = preNode.next;
            last = preNode;
        } else {
            //删除中间节点
            Node preNode = get(index - 1);
            removeNode = preNode.next;
            preNode.next = preNode.next.next;
            preNode.next.next = null;
        }
        size--;
        return removeNode;
    }

    /**
     * 链表插入元素
     *
     * @param data  插入的值
     * @param index 插入的位置
     */
    public void insert(int data, int index) {
        rangeCheckForAdd(index);
        Node node = new Node(data);
        if (size == 0) {
            //空链表
            head = node;
            last = node;
        } else if (index == 0) {
            node.next = head;
            head = node;
        } else if (size == index) {
            last.next = node;
            last = node;
        } else {
            Node preNode = get(index - 1);
            node.next = preNode.next;
            preNode.next = node;
        }
        size++;
    }

    /**
     * 链表查找位置
     *
     * @param index
     * @return
     */
    public Node get(int index) {
        rangeCheckForAdd(index);
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 输出链表
     */
    public void outPut() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("超出链表实际元素范围");
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.insert(3, 0);
        linkedList.insert(7, 1);
        linkedList.insert(4, 2);
        linkedList.insert(2, 3);
        linkedList.insert(1, 4);
        linkedList.insert(6, 5);
        linkedList.outPut();
        System.out.println();
        linkedList.remove(0);
        linkedList.outPut();
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}



