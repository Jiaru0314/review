package com.xzq.designpattern.proxy.dynamicproxy;

import com.xzq.designpattern.proxy.staticproxy.ITeacher;
import com.xzq.designpattern.proxy.staticproxy.Teacher;

/**
 * @ClassName: Client
 * @description:
 * @author: XZQ
 * @create: 2020/3/24 9:44
 **/
public class Client {
    public static void main(String[] args) {
        ITeacher teacher = new Teacher();

        final ITeacher proxyInstance = (ITeacher) new ProxyFactory(teacher).getProxyInstance();

        System.out.println("proxyInetance=" + proxyInstance.getClass());

        proxyInstance.teach();
        proxyInstance.sayHello("xuzhiqinag");

    }
}
