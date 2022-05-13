package com.network.model.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServerSocket {

    public static void main(String[] args) {
        ServerSocket serverSocket=null;

        try {
            serverSocket=new ServerSocket(8080);
            System.out.println("服务启动");
            while (true){
                Socket accept = serverSocket.accept();
                InputStream inputStream = accept.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                String s = bufferedReader.readLine();
                System.out.println("收到客户端消息："+s);
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
                bufferedWriter.write("receive a message:"+s );
                bufferedWriter.flush();
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
