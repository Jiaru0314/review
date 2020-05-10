package com.xzq.thread;

import java.util.concurrent.*;

/**
 * @ClassName: CallableDemo
 * @description: callable和runnable对比
 * 1、返回值
 * callable有返回值 runnable没有
 * 2、异常
 * callable有返异常 runnable没有
 * 3、方法不一样
 * callable：call runnable:run
 * @author: XZQ
 * @create: 2020/2/28 20:37
 **/
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask, "aaa").start();
        //new Thread(futureTask, "BBB").start();//复用，直接取值，不要重启两个线程
        //多个线程抢一个futureTask只算一次

        int result = 0;
        while (!futureTask.isDone()) {//当futureTask完成后取值

        }
        result = futureTask.get();
        //get():获取任务执行结果，如果任务还没完成则会阻塞等待直到任务执行完成。如果任务被取消则会抛出CancellationException异常，
        //int result = futureTask.get();建议放在最后
        System.out.println("result:\t" + result);

    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("callable come in");
        TimeUnit.SECONDS.sleep(2);
        return 1024;
    }
}

class MyThread2 implements Runnable {

    @Override
    public void run() {
    }
}
