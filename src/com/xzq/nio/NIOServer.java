package com.xzq.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName: NioServer
 * @description: NIO快速入门 服务端示例
 * @author: XZQ
 * @create: 2020/4/18 9:42
 **/
public class NIOServer {
    public static void main(String[] args) throws Exception {
        //得到一个Selector对象
        Selector selector = Selector.open();

              //创建ServerSockerChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //绑定一个端口6666
        serverSocketChannel.bind(new InetSocketAddress(6666));
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //把serverSocketChannel注册到selector 事件为OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //循环等待客户端连接
        while (true) {
            //等待一秒
            if (selector.select(1000) == 0) {
                System.out.println("等待1s,无事件发生");
                continue;
            }

            //如果返回的不>0 获取关注的事件
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //遍历selectionKeys
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {//如果是OP_ACCEPT
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端连接成功，程池一个socketChannel" + socketChannel.hashCode());
                    socketChannel.configureBlocking(false);
                    //将sockerchannel注册到selector 关注事件为OP_READ 关联一个buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                } else if (key.isReadable()) {//如果发生OP_READ
                    //通过key获取到channel
                    SocketChannel channel = (SocketChannel) key.channel();
                    //获取到绑定的buffer
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    channel.read(buffer);
                    System.out.println("from 客户端 " + new String(buffer.array()));
                }
                //手动从集合中移除selectionKey
                iterator.remove();
            }
        }
    }
}
