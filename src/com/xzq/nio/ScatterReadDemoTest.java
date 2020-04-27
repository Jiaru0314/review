package com.xzq.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName: TestScatterReadDemo
 * @description: 分散读取和聚集写入
 * @author: XZQ
 * @create: 2020/4/15 10:39
 **/
public class ScatterReadDemoTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile =
                new RandomAccessFile("E:\\MyFolder\\评奖评优\\申请理由.txt", "rw");

        FileChannel channel = randomAccessFile.getChannel();

        ByteBuffer byteBuffer1 = ByteBuffer.allocate(10);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);

        ByteBuffer[] byteBuffers = {byteBuffer1, byteBuffer2};

        channel.read(byteBuffers);
        for (ByteBuffer byteBuffer : byteBuffers) {
            byteBuffer.flip();
        }

        System.out.println(new String(byteBuffers[0].array(), 0, byteBuffers[0].limit(), "gb2312"));
        System.out.println("------------------------------");
        System.out.println(new String(byteBuffers[1].array(), 0, byteBuffers[1].limit(), "gb2312"));

        //聚集写入
        RandomAccessFile accessFile = new RandomAccessFile("2.txt", "rw");
        FileChannel channel2 = accessFile.getChannel();
        channel2.write(byteBuffers);
    }
}
