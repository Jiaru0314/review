package com.xzq.thread.singleton;

/**
 * @ClassName: InnerClassSingletonDemo
 * @description:
 * @author: XZQ
 * @create: 2020/3/16 10:20
 **/
public class InnerClassSingletonDemo {

    /*私有构造函数*/
    private InnerClassSingletonDemo() {
        System.out.println("single");
    }

    private static class Inner {
        private static InnerClassSingletonDemo inner = new InnerClassSingletonDemo();
    }

    public static InnerClassSingletonDemo getInstance() {
        return Inner.inner;
    }

    public static void main(String[] args) {
//        System.out.println(InnerClassSingletonDemo.getInstance() == InnerClassSingletonDemo.getInstance());
        //并发多线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                InnerClassSingletonDemo.getInstance();
            }, "Thread " + i).start();
        }
    }
}
