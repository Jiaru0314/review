package com.xzq.剑指offer.struct;

/**
 * @ClassName: BinaryTreeNode
 * @description:
 * @author: XZQ
 * @create: 2020/4/28 9:53
 **/
public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;

    }
}
