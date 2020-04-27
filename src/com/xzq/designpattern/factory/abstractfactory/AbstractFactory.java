package com.xzq.designpattern.factory.abstractfactory;

/**
 * @InterfaceName: AbstractFactory
 * @description:
 * @author: XZQ
 * @create: 2020/3/29 17:18
 **/
public abstract class AbstractFactory {

    public abstract Phone createPhone(String brand);

    public abstract Computer createComputer(String brand);
}
