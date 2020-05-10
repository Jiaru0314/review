package com.xzq.collection.set;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @ClassName: TestLinkedHashSet
 * @description: LinkedHashSet有序
 * @author: XZQ
 * @create: 2020/5/6 20:22
 **/
public class TestLinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
