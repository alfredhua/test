package com.network.model.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServerSockWithThread {

    static ExecutorService executorService= Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        ServerSocket serverSocket=null;
        try {
            serverSocket=new ServerSocket(8080);
            System.out.println("服务启动");
            //表示阻塞监听一个客户端连接
            while (true){
                Socket accept = serverSocket.accept();
                //IO变成异步执行
                executorService.submit(new SocketThread(accept));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
