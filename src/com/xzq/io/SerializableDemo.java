package com.xzq.io;

import com.xzq.pojo.User;

import java.io.*;

/**
 * @ClassName: serializable
 * @description: 将一个java对象序列化到文件里
 * @author: XZQ
 * @create: 2020/3/25 9:36
 **/
public class SerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream(new File("D://obj")));

        objectOutputStream.writeObject(new User("zhangsan", 10));
        objectOutputStream.writeObject(new User("lisi", 11));

        objectOutputStream.close();


        ObjectInputStream objectInputStream =
                new ObjectInputStream(new FileInputStream(new File("D://obj")));
        User user1 = (User) objectInputStream.readObject();
        User user2 = (User) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(user1);
        System.out.println(user2);
    }
}
