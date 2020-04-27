package com.xzq.designpattern.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @ClassName: ProxyFactory
 * @description: JDK动态代理
 * @author: XZQ
 * @create: 2020/3/24 9:38
 **/
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }


    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("JDK动态代理开始");
                    Object invoke = method.invoke(target, args);
                    System.out.println("动态代理结束");
                    return invoke;
                });
    }
}
