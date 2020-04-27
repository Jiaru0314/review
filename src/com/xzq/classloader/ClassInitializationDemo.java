package com.xzq.classloader;

/**
 * @ClassName: ClassInitializationDemo
 * @description: 类初始化顺序
 * @author: XZQ
 * @create: 2020/3/1 9:34
 **/
public class ClassInitializationDemo {
    public static void main(String[] args) {
        Father father = new Son();
        System.out.println("====================");
        Father father2 = new Son();
    }
}


class Father {

    public Father() {
        System.out.println("加载父类构造函数");

    }

    public static String fatherStaicVar = "父类静态变量";

    static {
        System.out.println("加载父类静态代码块");
        System.out.println("加载" + fatherStaicVar);
    }

    {
        System.out.println("加载父类普通代码块");
    }
}


class Son extends Father {

    public Son() {
        System.out.println("加载子类构造函数");
    }

    public static String sonStaicVar = "子类静态变量";

    static {
        System.out.println("加载子类静态代码块");
        System.out.println("加载" + sonStaicVar);
    }

    {
        System.out.println("加载子类普通代码块");
    }
}
