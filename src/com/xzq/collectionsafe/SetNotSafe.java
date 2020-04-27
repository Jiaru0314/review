package com.xzq.collectionsafe;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @ClassName: SetNotSafe
 * @description: Set不安全解决方案
 * @author: XZQ
 * @create: 2020/1/17 21:35
 * 1、存在问题 java.util.ConcurrentModificationException
 * 2、解决方案
 * 1、Collections.synchronizedSet(new HashSet<>());
 * 2、CopyOnWriteArraySet<>();
 **/
public class SetNotSafe {

    public static void main(String[] args) {
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 80; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}
