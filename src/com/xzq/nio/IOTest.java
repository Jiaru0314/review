package com.xzq.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName: TestIO
 * @description: 使用IO实现文件复制
 * @author: XZQ
 * @create: 2020/4/14 22:37
 **/
public class IOTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("1.jpg");
        FileOutputStream fos = new FileOutputStream("3.jpg");

        byte[] bytes = new byte[1024];
        while (fis.read(bytes) != -1) {
            fos.write(bytes);
        }

        fis.close();
        fos.close();
    }
}
