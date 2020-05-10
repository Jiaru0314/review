package com.xzq.collection.safe;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName: ConcurrentModificationExceptionDemo2
 * @description:
 * @author: XZQ
 * @create: 2020/3/27 23:21
 **/
public class ConcurrentModificationExceptionDemo2 {
    static List list = new CopyOnWriteArrayList<Integer>();

    public static void main(String[] args) {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Thread thread1 = new Thread(() -> {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                Integer integer = iterator.next();
                System.out.println(integer);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                Integer integer = iterator.next();
                if (integer == 2) {
//                    iterator.remove();
                    list.remove(integer);
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
