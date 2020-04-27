package com.xzq.designpattern.factory.abstractfactory;

/**
 * @ClassName: HuaweiPhone
 * @description:
 * @author: XZQ
 * @create: 2020/3/29 17:24
 **/
public class HuaweiPhone implements Phone {
    @Override
    public String call() {
        return "call somebody by huawei phone";
    }
}
