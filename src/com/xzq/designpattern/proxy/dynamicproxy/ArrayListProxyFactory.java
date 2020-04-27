package com.xzq.designpattern.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @ClassName: ArrayListProxyFactory
 * @description:
 * @author: XZQ
 * @create: 2020/3/24 15:02
 **/
public class ArrayListProxyFactory {

    private Object target;

    public ArrayListProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            System.out.println("JDK动态代理开始");
            Object result = method.invoke(target, args);
            System.out.println("JDK动态代理结束");
            return result;
        });
    }
}
