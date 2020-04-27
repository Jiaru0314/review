package com.xzq.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ReentrantLockDemo
 * @description: 可重入锁实现 A打印5次，B打印10次，C打印15次 精确唤醒
 * @author: XZQ
 * @create: 2020/2/28 19:56
 **/
public class ReentrantLockDemo {
    public static void main(String[] args) {
        final Resource resource = new Resource();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
//                resource.print5();
                resource.print(1);
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
//                resource.print10();
                resource.print(2);
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
//                resource.print15();
                resource.print(3);
            }
        }, "C").start();
    }

}

class Resource {
    private int number = 1;//A B C
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

/*    public void print5() {
        lock.lock();
        try {
            //判断
            while (number != 1) {
                //等待
                condition1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //通知
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            //判断
            while (number != 2) {
                //等待
                condition2.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //通知
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            //判断
            while (number != 3) {
                //等待
                condition3.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //通知
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }*/

    public void print(int num) {
        lock.lock();
        try {
            //判断
            while (number != num) {
                //等待
                switch (num) {
                    case 1:
                        condition1.await();
                        break;
                    case 2:
                        condition2.await();
                        break;
                    case 3:
                        condition3.await();
                        break;
                }
            }
            for (int i = 1; i <= 5 * num; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //通知
            number = num == 3 ? 1 : num + 1;
            switch (num) {
                case 1:
                    condition2.signal();
                    break;
                case 2:
                    condition3.signal();
                    break;
                case 3:
                    condition1.signal();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}