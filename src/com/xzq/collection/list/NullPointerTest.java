package com.xzq.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: NullPointerTest
 * @description:
 * @author: XZQ
 * @create: 2020/5/7 9:55
 **/
public class NullPointerTest {

    public static void main(String[] args) {

//        System.out.println(Integer.MAX_VALUE * 2);
//        System.out.println(Integer.MIN_VALUE * 2);


        List<String> a = new ArrayList<>();
        test(a);
        System.out.println(a.size());
    }

    public static void test(List<String> a) {
//        a = new ArrayList<>();
        a.add("abc");
    }
}
