package com.xzq.designpattern.factory.abstractfactory;

/**
 * @ClassName: PhoneFactory
 * @description:
 * @author: XZQ
 * @create: 2020/3/29 17:22
 **/
public class ComputerFactory extends AbstractFactory {
    @Override
    public Phone createPhone(String brand) {
        return null;
    }

    @Override
    public Computer createComputer(String brand) {
        if ("huawei".equals(brand)) {
            return new HuaweiComputer();
        } else if ("apple".equals(brand)) {
            return new AppleComputer();
        } else {
            return null;
        }
    }
}
