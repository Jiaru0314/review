package com.xzq.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: CountDownLatchDemo
 * @description:
 * @author: XZQ
 * @create: 2020/2/28 8:27
 **/
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t国，被灭");
                countDownLatch.countDown();
            }, CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t 六国灭");                //System.out.println(CountryEnum.SIX);        //System.out.println(CountryEnum.SIX.getRetCode());        //System.out.println(CountryEnum.SIX.getRetMessage());     }
    }
}
