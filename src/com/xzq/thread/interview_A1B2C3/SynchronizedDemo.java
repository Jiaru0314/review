package com.xzq.thread.interview_A1B2C3;

/**
 * @ClassName: SynchronizedDemo
 * @description: 两个线程交叉打印，一个打印数字，一个打印小写字母，结果为 1A2B3C4D5E6F
 * Synchronized实现
 * @author: XZQ
 * @create: 2020/3/15 16:15
 **/
public class SynchronizedDemo {
    static Object object = new Object();

    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(() -> {
            synchronized (object) {
                for (char c : aI) {
                    System.out.print(c);
                    try {
                        object.notify();//先notify再wait
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                object.notify();//必须 否则无法停止程序
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (object) {
                for (char c : aC) {
                    System.out.print(c);
                    try {
                        object.notify();
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                object.notify();//必须 否则无法停止程序
            }
        }, "t2").start();
    }
}
