package com.xzq.thread;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @ClassName: CyclicBarrierDemo
 * @description:
 * @author: XZQ
 * @create: 2020/2/28 10:31
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(6, () -> System.out.println("召唤神龙"));
        for (int i = 1; i <= 7; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println("继承第" + finalI + "颗龙珠");

            }, String.valueOf(i)).start();
        }
    }
}
