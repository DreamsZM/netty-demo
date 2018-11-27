package com.zy.ch1;

public class ServerBoot {

    private static final int PORT = 9999;

    public static void main(String[] args) {
        Server server = new Server(PORT);
        server.start();


    }
}
