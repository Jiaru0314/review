package com.xzq.thread.proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DynamicProxyDemo
 * @description: 动态代理类
 * @author: XZQ
 * @create: 2020/2/17 19:10
 **/
public class DynamicProxyDemo {
    public static void main(String[] args) {
        final List<String> list = new ArrayList<>();
        List<String> proxyInstance = (List<String>) Proxy.newProxyInstance(list.getClass().getClassLoader(),
                list.getClass().getInterfaces(), (proxy, method, args1) -> method.invoke(list, args1));

        proxyInstance.add("动态代理");
        System.out.println(list);
    }
}
