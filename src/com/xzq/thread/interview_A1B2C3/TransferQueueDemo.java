package com.xzq.thread.interview_A1B2C3;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @ClassName: TransferQueueDemo
 * @description: 两个线程交叉打印，一个打印数字，一个打印小写字母，结果为 1A2B3C4D5E6F
 * TransferQueue 实现方式
 * @author: XZQ
 * @create: 2020/3/15 16:54
 **/
public class TransferQueueDemo {
    public static void main(String[] args) {
        TransferQueue<Character> queue = new LinkedTransferQueue<>();
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(() -> {
            try {
                for (char c : aC) {
                    System.out.print(queue.take());
                    queue.transfer(c);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "t1").start();

        new Thread(() -> {
            try {
                for (char c : aI) {
                    queue.transfer(c);
                    System.out.print(queue.take());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "t2").start();
    }
}
