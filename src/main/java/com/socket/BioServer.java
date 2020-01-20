package com.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class BioServer {

    public BioServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(9090);
            while (true) {
                Socket accept = serverSocket.accept();
                InputStream inputStream = accept.getInputStream();
                byte[] bytes = new byte[1024];
                int read;
                do {
                    read = inputStream.read(bytes);
                    System.out.println(Arrays.toString(bytes));
                } while (read > 0);
                inputStream.close();
                OutputStream outputStream = accept.getOutputStream();
                outputStream.write("OK".getBytes());
                outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BioServer bioServer = new BioServer();
    }
}
