package com.xzq.designpattern.proxy.cglibproxy;

import com.xzq.designpattern.proxy.staticproxy.Teacher;

/**
 * @ClassName: Client
 * @description:
 * @author: XZQ
 * @create: 2020/3/24 14:12
 **/
public class Client {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        ProxyFactory proxyFactory = new ProxyFactory(teacher);
        Teacher proxyInstance = (Teacher) proxyFactory.getProxyInstance();

        String result = proxyInstance.sayHello("xuzhiqiang");
        System.out.println(result);

        proxyInstance.teach();
    }
}
