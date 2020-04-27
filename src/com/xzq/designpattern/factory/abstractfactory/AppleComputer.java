package com.xzq.designpattern.factory.abstractfactory;

/**
 * @ClassName: AppleComputer
 * @description:
 * @author: XZQ
 * @create: 2020/3/29 17:25
 **/
public class AppleComputer implements Computer {
    @Override
    public String internet() {
        return "internet by apple computer";
    }
}
