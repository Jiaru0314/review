package com.xzq.designpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ArrayListProxy
 * @description: 面试题：写一个Arraylist的动态代理
 * @author: XZQ
 * @create: 2020/3/24 15:13
 **/
public class ArrayListProxy {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> proxyInstance = (List<String>) Proxy.newProxyInstance(list.getClass().getClassLoader(),
                list.getClass().getInterfaces(), (proxy, method, args1) -> {
                    System.out.println("JDK动态代理");
                    final Object result = method.invoke(list, args1);
                    System.out.println("JDK动态代理");
                    return result;
                });

        proxyInstance.add("你好");
        System.out.println(list);

    }
}
