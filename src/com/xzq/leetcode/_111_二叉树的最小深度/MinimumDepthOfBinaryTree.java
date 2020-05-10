package com.xzq.leetcode._111_二叉树的最小深度;


import com.xzq.剑指offer.struct.BinaryTreeNode;

/**
 * @ClassName: MinimumDepthOfBinaryTree
 * @description: 二叉树的最小深度
 * @author: XZQ
 * @create: 2020/5/6 13:20
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 **/
public class MinimumDepthOfBinaryTree {

    public int minDepth(BinaryTreeNode root) {
        if (root == null)
            return 0;
        if (root.right == null && root.left == null)
            return 1;
        int min_depth = Integer.MAX_VALUE;
        if (root.right != null)
            min_depth = Math.min(minDepth(root.right), min_depth);
        if (root.left != null)
            min_depth = Math.min(minDepth(root.left), min_depth);
        return min_depth + 1;
    }
}
