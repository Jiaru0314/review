package com.xzq.designpattern.factory.abstractfactory;

/**
 * @ClassName: TestDemo
 * @description:
 * @author: XZQ
 * @create: 2020/3/29 17:31
 **/
public class TestDemo {
    public static void main(String[] args) {
        AbstractFactory phoneFactory = new PhoneFactory();
        AbstractFactory computerFactory = new ComputerFactory();

        Phone huaweiPhone = phoneFactory.createPhone("huawei");
        Phone applePhone = phoneFactory.createPhone("apple");
        System.out.println(huaweiPhone.call());
        System.out.println(applePhone.call());
    }
}
