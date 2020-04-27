package com.xzq.thread.threadpool;

import java.util.concurrent.*;

/**
 * @ClassName: MyThreadPool
 * @description: 手写一个线程池
 * @author: XZQ
 * @create: 2020/2/29 10:14
 **/
public class MyThreadPool {
    public static void main(String[] args) {
        ExecutorService threadPool =
                new ThreadPoolExecutor(
                        2,
                        5,
                        1,
                        TimeUnit.SECONDS,
                        new LinkedBlockingDeque<Runnable>(3),
                        Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.AbortPolicy());

        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }
}
