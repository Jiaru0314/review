package com.xzq.thread;

/**
 * @ClassName: ProdConsumer_TraditionDemo
 * @description: 传统方法 synchronized
 * @author: XZQ
 * @create: 2020/2/28 11:39
 * <p>
 * 题目：一个初始值为0的变量，两个线程对其操作，一个加1，一个减1.如此五轮
 * 线程 操作 资源类
 **/
public class ProdConsumer_TraditionDemo2 {
    public static void main(String[] args) {
        ShareData2 data = new ShareData2();
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

class ShareData2 {//资源类
    private int number = 0;
    private final Object lock = new Object();

    public void add() {
        synchronized (lock) {
            try {
                //判断
                while (number != 0) {
                    //等待不能生产
                    lock.wait();//线程A在执行lock.wait()时，会阻塞线程A，同时立即释放 lock锁， 这样 线程B 才能再次获取 lock对象锁。
                }
                number++;
                System.out.println(Thread.currentThread().getName() + "\t" + number);//干活
                //通知
                lock.notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void sub() {
        synchronized (lock) {
            try {
                //判断
                while (number == 0) {
                    //等待不能消费
                    lock.wait();
                }
                number--;
                System.out.println(Thread.currentThread().getName() + "\t" + number);//干活
                //通知
                lock.notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}