package com.xzq.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @ClassName: TestChannel
 * @description:
 * @author: XZQ
 * @create: 2020/4/14 22:22
 **/
public class ChannelTest {
    public static void main(String[] args) throws IOException {

//        directMemChannel();
        channelTransfer();
    }

    /*通道之间的数据传输*/
    public static void channelTransfer() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("E:\\image\\img9.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("img2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);

        inChannel.transferTo(0, inChannel.size(), outChannel);
        outChannel.transferFrom(inChannel, 0, inChannel.size());
        inChannel.close();
        outChannel.close();
    }

    /*使用直接缓冲区完成文件复制*/
    public static void directMemChannel() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("E:\\image\\img7.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("img.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);

        //内存映射文件
        MappedByteBuffer inMappedBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        byte[] dst = new byte[inMappedBuffer.limit()];
        inMappedBuffer.get(dst);
        outMappedBuffer.put(dst);

        inChannel.close();
        outChannel.close();
    }

    /*用通道实现文件的复制（非直接缓冲区）*/
    public static void testHeapChannel() throws IOException {
        FileInputStream fis = new FileInputStream("1.jpg");
        FileOutputStream fos = new FileOutputStream("2.jpg");

        //获取通道
        FileChannel fisChannel = fis.getChannel();
        FileChannel fosChannel = fos.getChannel();

        //分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (fisChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();//切换成读数据模式
            fosChannel.write(byteBuffer);
            byteBuffer.clear();//清空缓冲区
        }

        fosChannel.close();
        fisChannel.close();
        fis.close();
        fos.close();
    }
}
