package io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);

            new Thread(()->{
                while(true){
                    try {
                        Socket socket = serverSocket.accept();

                        new Thread(()->{

                            byte[] data = new byte[1024];
                            try {
                                InputStream inputStream = socket.getInputStream();
                                while(true){
                                    int len;
                                    while((len = inputStream.read(data)) != -1){
                                        System.out.println(new String(data, 0 , len));
                                    }
                                }
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }

                        }).start();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}