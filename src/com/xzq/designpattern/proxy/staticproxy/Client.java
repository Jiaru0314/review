package com.xzq.designpattern.proxy.staticproxy;

/**
 * @ClassName: Client
 * @description:
 * @author: XZQ
 * @create: 2020/3/24 9:24
 **/
public class Client {
    public static void main(String[] args) {
        final Teacher teacher = new Teacher();

        final TeacherProxy teacherProxy = new TeacherProxy(teacher);

        teacherProxy.teach();
        teacherProxy.sayHello("xuzhiqiang");
    }
}
