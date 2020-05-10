package com.xzq.剑指offer._54_二叉搜索树的第k大节点;

import com.xzq.剑指offer.struct.BinaryTreeNode;

/**
 * @ClassName: TheKthNodeInTree
 * @description: 二叉树的第K大节点
 * @author: XZQ
 * @create: 2020/5/9 14:48
 **/
public class TheKthNodeInTree {

    /*思路 中序遍历*/
    public BinaryTreeNode getKthNode(BinaryTreeNode root, int k) {
        if (root == null || k <= 0)
            return null;
        BinaryTreeNode target = null;

        if (root.left != null) {
            target = getKthNode(root.left, k);
        }

        if (target == null) {
            if (k == 1)
                target = root;
            k--;
        }

        if (target != null && root.left != null) {
            target = getKthNode(root.left, k);
        }
        return target;
    }

}
