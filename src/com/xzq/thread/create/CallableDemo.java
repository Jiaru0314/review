package com.xzq.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: CallableDemo
 * @description: Callable接口
 * @author: XZQ
 * @create: 2020/1/18 9:40
 * <p>
 * 三种获得线程的方法
 **/
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyThread2());
        new Thread(futureTask, "线程A").start();
        new Thread(futureTask2, "线程B").start();
        System.out.println(futureTask.get());
        System.out.println(futureTask2.get());

    }
}

//        new Thread(new MyThread()).start();
//        new MyThread3().start();

//Runable方式实现
class MyThread implements Runnable {

    @Override
    public void run() {
        //Runable方式创建线程 具体实现
        System.out.println("thread");
    }
}

//Callable方式实现
class MyThread2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("**** come in ****");
        return 1024;
    }
}


//继承Thread类 Thread本质上也是实现了Runnable 接口的一个实例，它代表一个线程的实例，
class MyThread3 extends Thread {
    public void run() {
        //继承Thread创建线程 具体实现
        System.out.println("thread3");
    }
}
