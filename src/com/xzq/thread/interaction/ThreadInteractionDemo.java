package com.xzq.thread.interaction;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: ThreadInteractionDemo
 * @description: 子线程运行执行10次后，主线程再运行5次。这样交替执行三遍
 * @author: XZQ
 * @create: 2020/2/3 11:12
 **/
public class ThreadInteractionDemo {
    public static void main(String[] args) {

        Bussiness bussiness = new Bussiness();
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                bussiness.childMethod();
            }
        }, "子线程").start();


        for (int i = 0; i <3 ; i++) {
            bussiness.mainMethod();
        }
    }
}

class Bussiness {
    private boolean flag = true;

    public synchronized void mainMethod() {
        while (!flag) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "打印" + i);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            flag = false;
            notify();
        }
    }

    public synchronized void childMethod() {
        while (flag) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "打印" + i);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            flag = true;
            notify();
        }
    }
}
