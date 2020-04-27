package com.xzq.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ProdConsumer_TraditionDemo
 * @description:
 * @author: XZQ
 * @create: 2020/2/28 11:39
 * <p>
 * 题目：一个初始值为0的变量，两个线程对其操作，一个加1，一个减1.如此五轮
 * 线程 操作 资源类
 **/
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData data = new ShareData();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                data.add();
            }
        }, "生产线程").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                data.sub();
            }
        }, "消费线程").start();
    }

}

class ShareData {//资源类
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void add() {
        lock.lock();
        try {
            //判断
            while (number != 0) {
                //等待不能生产
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);//干活
            //通知
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void sub() {
        lock.lock();
        try {
            //判断
            while (number == 0) {
                //等待不能消费
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);//干活
            //通知
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}