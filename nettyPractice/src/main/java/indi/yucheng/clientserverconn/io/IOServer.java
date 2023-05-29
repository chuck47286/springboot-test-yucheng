package indi.yucheng.clientserverconn.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);

        new Thread(() -> {
            while (true) {
                try {
                    Socket socket = serverSocket.accept();

                    // 为每条新链接创建线程
                    new Thread(() -> {
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();

                            while ((len = inputStream.read(data)) != -1) {
                                System.out.println(new String(data,0, len));
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
