package com.xzq.剑指offer._37_序列化二叉树;

import com.xzq.剑指offer.struct.BinaryTreeNode;

/**
 * @ClassName: SerializeBinaryTree
 * @description: 面试题37 :序列化二叉树
 * @author: XZQ
 * @create: 2020/4/28 19:04
 **/
public class SerializeBinaryTree {

    StringBuilder str = new StringBuilder();

    /*序列化*/
    public String serialize(BinaryTreeNode root) {
        if (root == null) {
            str.append("&,");
        } else {
            str.append(root.value + ",");
            serialize(root.left);
            serialize(root.right);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(2, binaryTreeNode4, null);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(3, binaryTreeNode5, binaryTreeNode6);
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(1, binaryTreeNode2, binaryTreeNode3);

        SerializeBinaryTree serializeBinaryTree = new SerializeBinaryTree();
        serializeBinaryTree.serialize(binaryTreeNode1);
        System.out.println(serializeBinaryTree.str.substring(0, serializeBinaryTree.str.length() - 1));
    }
}
