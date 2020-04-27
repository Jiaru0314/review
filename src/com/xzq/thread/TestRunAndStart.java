package com.xzq.thread;

/**
 * @ClassName: TestThread
 * @description: 执行run方法会启动线程吗?
 * @author: XZQ
 * @create: 2020/4/8 10:33
 * 启动线程需要调用thread.start()方法，如果只是调用了线程的run()方法，仅仅是调用了一个普通方法，并没有启动线程
 **/
public class TestRunAndStart {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.print("foo");
            }
        };

        Thread thread = new Thread(runnable);
        thread.run();
        System.out.print("bar");
    }
}
