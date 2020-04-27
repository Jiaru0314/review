package com.xzq.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @ClassName: TestBuffer
 * @description: 缓冲区测试
 * @author: XZQ
 * @create: 2020/4/14 20:58
 * <p>
 * 一、缓冲区在Java NIO 中负责数据的存取。缓冲区就是数组。用于存储不同数据类型的数据
 * 二、缓冲区管理方式几乎一致，都是通过allocate()来获取缓冲区
 * 三、缓冲区存取数据的两个核心方法:
 * put()
 * get()
 * 四、缓冲区中的核心属性
 * private int mark = -1;
 * private int position = 0;
 * private int limit;      界限，表示缓冲区中可以操作数据的大小（limit后的数据不能改变）
 * private int capacity; 容量，一但生命不可改变，代表缓冲区的最大大小
 * <p>
 * postition<=limit<=capacity
 **/
public class ByteBufferTest {
    public static void main(String[] args) {
        //分配一个指定大小的缓冲区
        System.out.println("---------allocate----------");
        ByteBuffer buffer = ByteBuffer.allocate(10);
        printBufferAttr(buffer);

        System.out.println("-----------put-------------");
        String str = "xzq";
        buffer.put(str.getBytes());
        printBufferAttr(buffer);

        //切换到读数据模式
        System.out.println("-----------flip-------------");
        buffer.flip();
        printBufferAttr(buffer);

        System.out.println("-----------get-------------");
        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst, 0, 1);
        System.out.println(new String(dst, 0, 1));
        printBufferAttr(buffer);

        System.out.println("-----------mark-------------");
        buffer.mark();
        buffer.get(dst, 1, 1);
        System.out.println(new String(dst, 1, 1));
        printBufferAttr(buffer);

        System.out.println("-----------reset-------------");
        buffer.reset();
        printBufferAttr(buffer);

        System.out.println("-----------rewind-------------");
        buffer.rewind();//将位置设置为0，取消mark
        printBufferAttr(buffer);

        //清空缓冲区，但是数据依然存在，处于被遗忘状态(属性还原到最初状态)
        System.out.println("----------clear--------------");
        buffer.clear();
        printBufferAttr(buffer);

        System.out.println("---------get--------");
        System.out.println((char) buffer.get());
        printBufferAttr(buffer);

        //查看缓冲区中是否还有元素，如果有，返回 position 和 limit 之间的元素个数
        System.out.println("---------remain--------");
        if (buffer.hasRemaining()){
            System.out.println(buffer.remaining());
        }
    }

    private static void printBufferAttr(Buffer buffer) {
        System.out.println("容量" + buffer.capacity());
        System.out.println("界限" + buffer.limit());
        System.out.println("位置" + buffer.position());
    }
}
