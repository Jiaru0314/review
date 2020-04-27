package com.xzq.thread.interview_A1B2C3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ReentrantLockDemo
 * @description: 两个线程交叉打印，一个打印数字，一个打印小写字母，结果为 1A2B3C4D5E6F
 * ReentrantLock 实现方式
 * @author: XZQ
 * @create: 2020/3/15 16:27
 **/
public class ReentrantLockDemo {

    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        ReentrantLock reentrantLock = new ReentrantLock();//默认非公平锁
        Condition condition = reentrantLock.newCondition();

        new Thread(() -> {
            try {
                reentrantLock.lock();
                for (char c : aI) {
                    System.out.print(c);
                    condition.signal();
                    condition.await();
                }
                condition.signal();//必须 否则无法停止程序
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                reentrantLock.lock();
                for (char c : aC) {
                    System.out.print(c);
                    condition.signal();
                    condition.await();
                }
                condition.signal();//必须 否则无法停止程序
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }, "t2").start();
    }
}
