package com.network.model.bio;

import java.io.*;
import java.net.Socket;

public class SocketThread implements Runnable{
    private Socket accept;

    public SocketThread(Socket serverSocket) {
        this.accept = serverSocket;
    }


    @Override
    public void run() {
        try {
            InputStream inputStream = accept.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String s = bufferedReader.readLine();
            System.out.println("收到客户端消息：" + s);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
            bufferedWriter.write("receive a message:" + s);
            bufferedWriter.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (accept!=null){
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
