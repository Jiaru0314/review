package com.xzq.剑指offer.utils;


import com.xzq.剑指offer.struct.BinaryTreeNode;

/**
 * @ClassName: TreeUtils
 * @description: 树的工具类
 * @author: XZQ
 * @create: 2020/4/28 10:11
 **/
public class TreeUtils {
    /*前序遍历二叉树 根、左、右*/
    public static void preOrderTraverse(BinaryTreeNode node) {
        if (node == null)
            return;
        System.out.print(node);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    /*中序遍历二叉树 左、根、右*/
    public static void inOrderTraverse(BinaryTreeNode node) {
        if (node == null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.value + " ");
        inOrderTraverse(node.right);
    }
}
