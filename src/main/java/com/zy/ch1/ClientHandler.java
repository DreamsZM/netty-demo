package com.zy.ch1;

import java.io.*;
import java.net.Socket;

public class ClientHandler {

    private static final int MAX_DATA_LEN = 1024;

    private final Socket socket;

    public ClientHandler(Socket socket){
        this.socket = socket;
    }

    public void start(){
        System.out.println("新客户端接入");
        new Thread(new Runnable() {
            @Override
            public void run() {
                doStart();
            }
        }).start();
    }

    private void doStart(){

        try {
            InputStream inputStream = socket.getInputStream();
            while (true){
                int len;
                byte[] date = new byte[MAX_DATA_LEN];
                while ((len = inputStream.read(date)) != -1){
                    String message = new String(date, 0, len);
                    System.out.println("客户端传来的消息：" + message);
                    socket.getOutputStream().write(date);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
