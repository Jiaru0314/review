package com.xzq.designpattern.proxy.staticproxy;

/**
 * @ClassName: Teacher
 * @description: 静态代理 接口实现类
 * @author: XZQ
 * @create: 2020/3/24 9:19
 **/
public class Teacher implements ITeacher {
    @Override
    public void teach() {
        System.out.println("老师上课");
    }

    @Override
    public String sayHello(String name) {
        System.out.println("hello " + name);
        return name;
    }
}
