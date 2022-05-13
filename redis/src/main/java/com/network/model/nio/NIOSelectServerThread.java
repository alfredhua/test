package com.network.model.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOSelectServerThread implements Runnable {

    Selector selector;
    ServerSocketChannel serverSocketChannel;

    public NIOSelectServerThread(int port) throws IOException {
        selector=Selector.open();
        serverSocketChannel=ServerSocketChannel.open();
        //如果采用selector模型，必须要设置非阻塞
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }
    @Override
    public void run() {
        while (!Thread.interrupted()){
            try {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    dispatch(iterator.next());
                    iterator.remove();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void dispatch(SelectionKey key) throws IOException {
        if(key.isAcceptable()){ //是连接事件？
            register(key);
        }else if(key.isReadable()){ //读事件
            read(key);
        }else if(key.isWritable()){ //写事件
            //TODO
        }
    }
    private void register(SelectionKey key) throws IOException {
        ServerSocketChannel channel= (ServerSocketChannel) key.channel(); //客户端连接
        SocketChannel socketChannel=channel.accept(); //获得客户端连接
        socketChannel.configureBlocking(false);
        socketChannel.register(selector,SelectionKey.OP_READ);
    }
    private void read(SelectionKey key) throws IOException {
        //得到的是socketChannel
        SocketChannel channel= (SocketChannel) key.channel();
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        channel.read(byteBuffer);
        System.out.println("Server Receive Msg:"+new String(byteBuffer.array()));
    }

    public static void main(String[] args) throws IOException {
        NIOSelectServerThread selectorServerSocket=new NIOSelectServerThread(8080);
        new Thread(selectorServerSocket).start();
    }
}
