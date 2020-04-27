package com.xzq.designpattern.singleton;

/**
 * @ClassName: Singleton01
 * @description:
 * @author: XZQ
 * @create: 2020/2/21 18:04
 **/
public class SingletonDemo {

    /**
     * 私有化构造函数
     */
    private SingletonDemo() {
    }

    /**
     * 使用volatile防止指令重排序
     */
    private static volatile SingletonDemo instance = null;

    /**
     * 双重校验
     *
     * @return
     */
    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
    }
}
