package com.xzq.thread;

/**
 * @ClassName: volatileDemo
 * @description: 验证volatile不保证原子性
 * @author: XZQ
 * @create: 2020/2/26 8:34
 **/
public class volatileAtomicityDemo {

    public static void main(String[] args) {
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.add();
                    myData.atomicAdd();
                }
            }, i + "").start();
        }

        //等待上面20线程全部计算完毕 再用main线程取得最终结果输出 后台有GC线程和mai'n线程
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + " finally num value" + myData.num);
        System.out.println(Thread.currentThread().getName() + " finally atomicnum value" + myData.atomicInteger);
    }

}
