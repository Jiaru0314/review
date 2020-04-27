package com.xzq.thread.join;

/**
 * @ClassName: JoinDemo
 * @description: join -> Waits for this thread to die.
 * @author: XZQ
 * @create: 2020/3/16 10:00
 **/
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        }, "t1");
        thread.start();
        thread.join();

        System.out.println("完成");
    }
}
