package com.xzq.designpattern.factory.abstractfactory;

/**
 * @ClassName: HuaweiComputer
 * @description:
 * @author: XZQ
 * @create: 2020/3/29 17:26
 **/
public class HuaweiComputer implements Computer {
    @Override
    public String internet() {
        return "internet by huawei computer";
    }
}
