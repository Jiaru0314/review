package com.xzq.designpattern.factory.abstractfactory;

/**
 * @ClassName: ApplePhone
 * @description:
 * @author: XZQ
 * @create: 2020/3/29 17:24
 **/
public class ApplePhone implements Phone {
    @Override
    public String call() {
        return "call somebody by apple phone";
    }
}
