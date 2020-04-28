package com.xzq.剑指offer._27_二叉树的镜像;

import com.xzq.剑指offer.struct.BinaryTreeNode;
import com.xzq.剑指offer.utils.TreeUtils;

/**
 * @ClassName: MirrorOfBinaryTree
 * @description: 二叉树的镜像
 * @author: XZQ
 * @create: 2020/4/28 9:51
 * 题目 :请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 思路
 * 　　画图可以很清晰地得到思路：先前序遍历，对每个结点交换左右子结点。
 **/
public class MirrorOfBinaryTree {

    public void mirrorRecursively(BinaryTreeNode rootNode) {
        if (rootNode == null)
            return;

        if (rootNode.left == null && rootNode.right == null)
            return;

        BinaryTreeNode tempNode = rootNode.right;
        rootNode.right = rootNode.left;
        rootNode.left = tempNode;
        mirrorRecursively(rootNode.left);
        mirrorRecursively(rootNode.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode binaryTreeNode9 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode binaryTreeNode11 = new BinaryTreeNode(11, null, null);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(6, binaryTreeNode5, binaryTreeNode7);
        BinaryTreeNode binaryTreeNode10 = new BinaryTreeNode(10, binaryTreeNode9, binaryTreeNode11);
        BinaryTreeNode binaryTreeNode8 = new BinaryTreeNode(8, binaryTreeNode6, binaryTreeNode10);

        new MirrorOfBinaryTree().mirrorRecursively(binaryTreeNode8);
        TreeUtils.inOrderTraverse(binaryTreeNode8);
    }
}


/*
收获
　　画图使抽象问题形象化，面试时要在编程前先用画图、举例子等来解释思路。
*/