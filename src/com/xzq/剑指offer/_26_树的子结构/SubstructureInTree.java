package com.xzq.剑指offer._26_树的子结构;

import com.xzq.剑指offer.utils.DoubleUtils;

/**
 * @ClassName: SubstructureInTree
 * @description: 面试题26 树的子结构
 * @author: XZQ
 * @create: 2020/4/27 20:18
 **/
public class SubstructureInTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);

        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(2);


        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        node5.right = node7;

        node8.left = node9;
        node8.right = node10;


        System.out.println(new SubstructureInTree().hasSubTree(node1, node8));
    }

    /*
     * 主程序，对每个结点遍历判断
     */
    public boolean hasSubTree(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return false;
        if (root2 == null)
            return true;

        boolean result = false;
        if (DoubleUtils.isDoubleEqual(root1.val, root2.val)) {
            result = doesTree1HasTree2(root1, root2);
        }
        if (!result)
            result = hasSubTree(root1.left, root2);
        if (!result)
            result = hasSubTree(root1.right, root2);
        return result;
        //上面几行可以直接写成：
//        return doesTree1HasTree2(root1, root2) || hasSubTree(root1.left, root2)
//                || hasSubTree(root1.right, root2);
    }

    /*
     * 判断root结点开始的子树中各个结点是否相同
     */
    public boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        return DoubleUtils.isDoubleEqual(root1.val, root2.val)
                && doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
    }
}

class TreeNode {
    double val;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}