package com.xzq.thread.interview_A1B2C3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ReentrantLockDemo
 * @description: 两个线程交叉打印，一个打印数字，一个打印小写字母，结果为 1A2B3C4D5E6F
 * ReentrantLock&Condition 实现方式
 * 优点:支持指定线程唤醒和指定线程等待
 * @author: XZQ
 * @create: 2020/3/15 16:27
 **/
public class ReentrantLock_ConditionDemo {

    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        Lock lock = new ReentrantLock();//默认非公平锁
        Condition condition1 = lock.newCondition();//队列
        Condition condition2 = lock.newCondition();

        new Thread(() -> {
            try {
                lock.lock();
                for (char c : aI) {
                    System.out.print(c);
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();//必须 否则无法停止程序
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                lock.lock();
                for (char c : aC) {
                    System.out.print(c);
                    condition1.signal();
                    condition2.await();
                }
                condition1.signal();//必须 否则无法停止程序
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }
}
