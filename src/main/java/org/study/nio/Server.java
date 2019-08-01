package org.study.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ArnoldLee on 18/9/11.
 */
public class Server {

    private ServerSocket serverSocket;

    public Server(int port){
        this.serverSocket = serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务端启动成功,端口:"+port);
        } catch (IOException e) {
            System.err.println("服务端启动失败,端口:"+port);
        }
    }

    public void start(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                doStart();
            }
        }).start();


    }

    private void doStart() {
        while (true){
            try {
                Socket client = serverSocket.accept();
                new ClientHandler(client).start();
            } catch (IOException e) {
                System.err.println("服务端异常");
            }

        }
    }

}
