package com.xzq.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: volatileDemo
 * @description: 验证volatile的可见性
 * @author: XZQ
 * @create: 2020/2/26 8:34
 **/
public class volatileVisibilityDemo {

    public static void main(String[] args) {
        MyData myData = new MyData();//资源类
        //第一个线程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t update num value" + myData.num);
        }, "AAA").start();

        //第二个线程是main线程
        while (myData.num == 0) {//如果myData的num一直为零，main线程一直在这里循环

        }

        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }
}

class MyData {
    //    int num = 0;
    volatile int num = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

    public void addTo60() {
        this.num = 60;
    }

    public void add() {
        this.num++;
    }

    public void atomicAdd() {
        atomicInteger.getAndIncrement();
    }

}
