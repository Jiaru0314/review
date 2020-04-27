package com.xzq.collectionsafe;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @ClassName: ConcurrentModificationExceptionDemo
 * @description: 并发修改异常案例
 * @author: XZQ
 * @create: 2020/3/27 22:41
 **/
public class ConcurrentModificationExceptionDemo {
    public static void main(String[] args) {
        final ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        final Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().equals(1)) {
//                list.remove(1);
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
