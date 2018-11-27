package com.zy.ch1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    private static final int PORT = 9999;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Socket socket = new Socket("localhost", PORT);
                        OutputStream outputStream = socket.getOutputStream();
                        String msg = "Hello world!";
                        outputStream.write(msg.getBytes());
                        try {
                            Thread.sleep(3000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();


    }
}
