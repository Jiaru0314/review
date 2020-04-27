package com.xzq.designpattern.factory.abstractfactory;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @ClassName: ComputerFactory
 * @description:
 * @author: XZQ
 * @create: 2020/3/29 17:28
 **/
public class PhoneFactory extends AbstractFactory {
    @Override
    public Phone createPhone(String brand) {
        if ("huawei".equals(brand)) {
            return new HuaweiPhone();
        } else if ("apple".equals(brand)) {
            return new ApplePhone();
        } else {
            return null;
        }

    }

    @Override
    public Computer createComputer(String brand) {
        return null;
    }
}
