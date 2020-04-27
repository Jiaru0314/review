package com.xzq.剑指offer;

import java.util.Arrays;

/**
 * @ClassName: ConstructBinaryTree
 * @description: 重建二叉树
 * @author: XZQ
 * @create: 2020/4/25 18:36
 **/
public class ConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //判断数组条件是否符合规范
        if (pre == null || in == null || pre.length <= 0 || in.length <= 0 || pre.length != in.length) {
            throw new RuntimeException("数组不符合规范");
        }
        //符合条件 构造二叉树
        return construct(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    /**
     * @Description 由前序遍历序列和中序遍历序列得到根结点
     * pre、in：始终用最初的前序遍历和中序遍历数组代入
     * pStart、pEnd：当前树的前序数组开始和结束位置
     * iStart、iEnd：中序数组开始和结束位置
     */
    public TreeNode construct(int[] pre, int[] in, int pStart, int pEnd, int iStart, int iEnd) {
        // 没有符合前序和中序的二叉树或已经到达叶子节点
        if (pStart > pEnd || iStart > iEnd)
            return null;

        TreeNode root = new TreeNode(pre[pStart]);//根节点
        for (int i = iStart; i <= iEnd; i++) {//遍历中序遍历序列
            if (in[i] == pre[pStart]) {//找到根节点在中序序列中的位置
                root.left = construct(pre, in, pStart + 1, i - iStart + pStart, iStart, i - 1);
                root.right = construct(pre, in, i - iStart + pStart + 1, pEnd, i + 1, iEnd);
            }
        }
        return root;
    }

    /*Arrays.copyOfRange*/
    public TreeNode reConstructBinaryTree2(int[] pre, int[] in) {
        //判断数组条件是否符合规范
        if(pre.length == 0|| pre.length!=in.length){
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                root.left = reConstructBinaryTree2(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree2(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return root;
    }


    public static void main(String[] args) {
        ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
        constructBinaryTree.test1();
        constructBinaryTree.test2();
        constructBinaryTree.test3();
        constructBinaryTree.test4();
        constructBinaryTree.test5();
    }

    /**
     * 正常二叉树
     */
    public void test1() {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = reConstructBinaryTree(pre, in);
        System.out.print("test1:");
        preOrderTraverse(root);
        System.out.print("//");
        inOrderTraverse(root);
        System.out.println();
    }

    /**
     * 左斜树
     */
    public void test2() {
        int[] pre = {1, 2, 3, 4, 5};
        int[] in = {5, 4, 3, 2, 1};
        TreeNode root = reConstructBinaryTree(pre, in);
        System.out.print("test2:");
        preOrderTraverse(root);
        System.out.print("//");
        inOrderTraverse(root);
        System.out.println();
    }

    /**
     * 右斜树
     */
    public void test3() {
        int[] pre = {1, 2, 3, 4, 5};
        int[] in = {1, 2, 3, 4, 5};
        TreeNode root = reConstructBinaryTree(pre, in);
        System.out.print("test3:");
        preOrderTraverse(root);
        System.out.print("//");
        inOrderTraverse(root);
        System.out.println();
    }

    /**
     * 单个结点
     */
    public void test4() {
        int[] pre = {1};
        int[] in = {1};
        TreeNode root = reConstructBinaryTree(pre, in);
        System.out.print("test4:");
        preOrderTraverse(root);
        System.out.print("//");
        inOrderTraverse(root);
        System.out.println();
    }

    /**
     * 数组为空
     */
    public void test5() {
        int[] pre = {};
        int[] in = {};
        TreeNode root = reConstructBinaryTree(pre, in);
        System.out.print("test5:");
        preOrderTraverse(root);
        System.out.print("//");
        inOrderTraverse(root);
        System.out.println();
    }

    /*前序遍历二叉树 根、左、右*/
    private void preOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    /*中序遍历二叉树 左、根、右*/
    private void inOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.val);
        inOrderTraverse(node.right);
    }
}

class TreeNode {
    int val;

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode left;
    TreeNode right;
}