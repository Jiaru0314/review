package com.xzq.thread;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: DeadLockDemo
 * @description: 死锁
 * @author: XZQ
 * @create: 2020/2/29 11:02
 **/
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldThread(lockA, lockB), "aaa").start();
        new Thread(new HoldThread(lockB, lockA), "bbb").start();
    }
}

class HoldThread implements Runnable {
    private String lockA;
    private String lockB;

    public HoldThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "正在持有锁" + lockA + "尝试获取锁" + lockB);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "正在持有锁" + lockB + "尝试获取锁" + lockA);
            }
        }
    }
}
