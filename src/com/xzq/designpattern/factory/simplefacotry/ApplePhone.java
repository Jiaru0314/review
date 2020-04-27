package com.xzq.designpattern.factory.simplefacotry;

/**
 * @ClassName: ApplePhone
 * @description:
 * @author: XZQ
 * @create: 2020/3/29 17:05
 **/
public class ApplePhone implements Phone {
    @Override
    public String brand() {
        return "this is apple phone";
    }
}
