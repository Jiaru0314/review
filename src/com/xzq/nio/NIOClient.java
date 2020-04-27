package com.xzq.nio;

import sun.security.x509.IPAddressName;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @ClassName: NioClient
 * @description: NIO入门示例 客户端代码
 * @author: XZQ
 * @create: 2020/4/18 10:27
 **/
public class NIOClient {
    public static void main(String[] args) throws Exception {
        //得到一个网络通道
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);
        //连接服务器
        if (!socketChannel.connect(inetSocketAddress)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("因为连接需要事件客户端不会阻塞");
            }
        }
        String str = "hello xzq";
        ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());
        //数据写入channel
        socketChannel.write(byteBuffer);
        System.in.read();
    }
}
