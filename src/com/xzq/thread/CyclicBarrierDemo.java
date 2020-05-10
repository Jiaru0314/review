package com.xzq.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName: CyclicBarrierDemo
 * @description:
 * @author: XZQ
 * @create: 2020/2/28 10:31
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(6, () -> System.out.println("召唤神龙"));
        for (int i = 1; i <= 6; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println("继承第" + finalI + "颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
