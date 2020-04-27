package com.xzq.designpattern.factory.simplefacotry;

/**
 * @ClassName: HuaweiPhone
 * @description:
 * @author: XZQ
 * @create: 2020/3/29 17:06
 **/
public class HuaweiPhone implements Phone {
    @Override
    public String brand() {
        return "this is huawei phone";
    }
}
