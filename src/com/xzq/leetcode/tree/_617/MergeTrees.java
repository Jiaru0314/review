package com.xzq.leetcode.tree._617;

/**
 * @ClassName: _617_MergeTrees
 * @description:
 * @author: XZQ
 * @create: 2020/4/27 11:49
 **/
public class MergeTrees {
    public static void main(String[] args) {
        System.out.println(5/2);
    }

    /*
     * 方法一:递归思想
     * 我们可以对这两棵树同时进行前序遍历，并将对应的节点进行合并。
     * 在遍历时，如果两棵树的当前节点均不为空，我们就将它们的值进行相加，并对它们的左孩子和右孩子进行递归合并；
     * 如果其中有一棵树为空，那么我们返回另一颗树作为结果；如果两棵树均为空，此时返回任意一棵树均可（因为都是空）。
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :39.9 MB, 在所有 Java 提交中击败了91.18%的用户
     * */
    public TreeNode merge(TreeNode t1, TreeNode t2) {
        //判断t1或t2是否为null
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        t1.val += t2.val;
        t1.right = merge(t1.right, t2.right);
        t1.left = merge(t1.left, t2.left);
        return t1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}