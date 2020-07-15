package com.gao.nio;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NioTest12 {

    public static void main(String[] args) throws Exception{
        int[] ports = new int[5];
        ports[0] = 5000;
        ports[1] = 5001;
        ports[2] = 5002;
        ports[3] = 5003;
        ports[4] = 5004;
        Selector selector = Selector.open();
        for(int i=0;i<ports.length;i++){
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            ServerSocket serverSocket = serverSocketChannel.socket();
            InetSocketAddress address = new InetSocketAddress(ports[i]);
            serverSocket.bind(address);
            serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            System.out.println("监听端口："+ports[i]);

        }

        while (true){
            int numbers = selector.select();
            System.out.println("numbers: " + numbers);
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("selectionKeys: "+selectionKeys);
            Iterator<SelectionKey> iter = selectionKeys.iterator();

            while (iter.hasNext()){
                SelectionKey selectionKey = iter.next();
                if(selectionKey.isAcceptable()){
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel)selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_READ);

                    iter.remove();
                    System.out.println("获得客户端连接："+socketChannel);

                }else if (selectionKey.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    int bytesRead = 0;

                    while (true){
                        ByteBuffer bytebuffer = ByteBuffer.allocate(512);
                        bytebuffer.clear();
                        int read = socketChannel.read(bytebuffer);
                        if(read<0){
                            break;
                        }

                        bytebuffer.flip();
                        socketChannel.write(bytebuffer);
                        bytesRead+=read;
                    }
                    System.out.println("读取："+bytesRead+",来自于: "+socketChannel);
                    iter.remove();
                }

            }
        }

    }
}
















