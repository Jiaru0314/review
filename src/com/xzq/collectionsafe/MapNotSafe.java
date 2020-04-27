package com.xzq.collectionsafe;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: MapNotSafe
 * @description: Map不安全解决方案
 * @author: XZQ
 * @create: 2020/1/17 21:35
 * 1、存在问题 java.util.ConcurrentModificationException
 * 2、解决方案
 * 1、Collections.synchronizedMap(new HashMap<>());
 * 2、new ConcurrentHashMap<>();
 **/
public class MapNotSafe {

    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>(32);

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

}
