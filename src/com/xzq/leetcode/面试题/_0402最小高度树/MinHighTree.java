package com.xzq.leetcode.面试题._0402最小高度树;

import com.xzq.剑指offer.struct.BinaryTreeNode;
import com.xzq.剑指offer.utils.TreeUtils;

import java.util.Arrays;

/**
 * @ClassName: MinHighTree
 * @description: 最小高度树
 * @author: XZQ
 * @create: 2020/4/28 20:20
 * <p>
 * 题目：给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * 示例：给定有序数组: [-10,-3,0,5,9],一个可能的答案是：[0,-3,9,-10,null,5]
 * 参考：https://leetcode-cn.com/problems/minimum-height-tree-lcci/submissions/
 **/
public class MinHighTree {

    /*耗时1ms 内存销耗：40.6MB*/
    public BinaryTreeNode constructMinHighTree(int[] nums) {
        if (nums == null || nums.length <= 0)
            return null;
        int index = nums.length >> 1;
        BinaryTreeNode treeNode = new BinaryTreeNode(nums[index]);
        treeNode.left = constructMinHighTree(Arrays.copyOfRange(nums, 0, index));
        treeNode.right = constructMinHighTree(Arrays.copyOfRange(nums, index + 1, nums.length));
        return treeNode;
    }

    public BinaryTreeNode constructMinHighTree2(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    /*耗时 0ms ，内存消耗：39.6MB*/
    public BinaryTreeNode helper(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int index = (left + right) >> 1;
        BinaryTreeNode node = new BinaryTreeNode(nums[index]);
        node.left = helper(nums, left, index - 1);
        node.right = helper(nums, index + 1, right);
        return node;
    }


    public static void main(String[] args) {
        TreeUtils.preOrderTraverse(new MinHighTree().constructMinHighTree2(new int[]{-10, -3, 0, 5, 9}));
    }
}
