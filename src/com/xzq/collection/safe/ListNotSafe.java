package com.xzq.collection.safe;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName: ListNotSafe
 * @description: List不安全解决方案
 * @author: XZQ
 * @create: 2020/1/17 21:35
 * 1、存在问题 java.util.ConcurrentModificationException
 * 2、解决方案
 * 1、Vector
 * 2、Collections.synchronizedList(new ArrayList<>());
 * 3、CopyOnWriteArrayList<>();写时复制
 **/
public class ListNotSafe {

    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
