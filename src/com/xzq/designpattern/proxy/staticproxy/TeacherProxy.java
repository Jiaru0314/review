package com.xzq.designpattern.proxy.staticproxy;

/**
 * @ClassName: TeacherProxy
 * @description:
 * @author: XZQ
 * @create: 2020/3/24 9:20
 **/
public class TeacherProxy implements ITeacher {

    private ITeacher target;

    public TeacherProxy(ITeacher target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("开始代理");
        target.teach();
        System.out.println("代理完成");
    }

    @Override
    public String sayHello(String name) {
        System.out.println("开始代理");
        target.sayHello(name);
        System.out.println("代理完成");
        return name;
    }
}
