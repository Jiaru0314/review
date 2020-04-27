package com.xzq.thread.singleton;

/**
 * @ClassName: SingletonDemo
 * @description: 普通单例模式 在多线程环境下的问题
 * @author: XZQ
 * @create: 2020/2/26 10:23
 **/
public class CommonSingletonDemo {
    private static CommonSingletonDemo instance = null;

    private CommonSingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\t 构造方法SingletonDemo（）");
    }

    public static CommonSingletonDemo getInstance() {
        if (instance == null) {
            instance = new CommonSingletonDemo();
        }
        return instance;
    }

    public static void main(String[] args) {
        //构造方法只会被执行一次
//        System.out.println(getInstance() == getInstance());
//        System.out.println(getInstance() == getInstance());
//        System.out.println(getInstance() == getInstance());

        //并发多线程后，构造方法会在一些情况下执行多次
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                CommonSingletonDemo.getInstance();
            }, "Thread " + i).start();
        }
    }
}
