package com.xzq.剑指offer._32_从上到下打印二叉树;

import com.xzq.剑指offer.struct.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: PrintFromTopToBoottom
 * @description: 不分行从上到下打印二叉树
 * @author: XZQ
 * @create: 2020/4/28 15:42
 **/
public class PrintFromTopToBoottom {
    Queue<BinaryTreeNode> queue = new LinkedList<>();

    public void printTree(BinaryTreeNode root) {
        if (root == null)
            return;
        LinkedList<BinaryTreeNode> treeNodeQueue = new LinkedList<>();
        queue.offer(root);

        BinaryTreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.value + " ");
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
    }


    public void printTreeByLine(BinaryTreeNode root) {
        if (root == null)
            return;
        LinkedList<BinaryTreeNode> treeNodeQueue = new LinkedList<>();
        queue.offer(root);
        int pCount = 0;      //当前层结点数目
        int nextCount = 1;   //下一层结点数目
        BinaryTreeNode node = null;
        while (!queue.isEmpty()) {
            pCount = nextCount;
            nextCount = 0;
            //打印当前层数字，并计算下一层结点数目
            for (int i = 0; i < pCount; i++) {
                node = queue.poll();
                System.out.print(node.value + " ");

                if (node.left != null) {
                    queue.offer(node.left);
                    nextCount++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextCount++;
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode binaryTreeNode9 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode binaryTreeNode11 = new BinaryTreeNode(11, null, null);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(6, binaryTreeNode5, binaryTreeNode7);
        BinaryTreeNode binaryTreeNode10 = new BinaryTreeNode(10, binaryTreeNode9, binaryTreeNode11);
        BinaryTreeNode binaryTreeNode8 = new BinaryTreeNode(8, binaryTreeNode6, binaryTreeNode10);

        new PrintFromTopToBoottom().printTree(binaryTreeNode8);
        System.out.println();
        new PrintFromTopToBoottom().printTreeByLine(binaryTreeNode8);
    }
}
