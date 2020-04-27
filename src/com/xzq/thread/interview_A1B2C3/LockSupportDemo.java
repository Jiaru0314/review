package com.xzq.thread.interview_A1B2C3;

import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName: LockSupport
 * @description: 两个线程交叉打印，一个打印数字，一个打印小写字母，结果为 1A2B3C4D5E6F
 * LockSupport实现
 * @author: XZQ
 * @create: 2020/3/15 15:24
 **/
public class LockSupportDemo {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        t1 = new Thread(() -> {
            for (char c : aI) {
                System.out.print(c);
                LockSupport.unpark(t2);//叫醒t2 叫醒指定线程
                LockSupport.park();//T1阻塞 当前线程阻塞
            }
        }, "t1");


        t2 = new Thread(() -> {
            for (char c : aC) {
                LockSupport.park();//t2阻塞
                System.out.print(c);
                LockSupport.unpark(t1);//叫醒t1
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
