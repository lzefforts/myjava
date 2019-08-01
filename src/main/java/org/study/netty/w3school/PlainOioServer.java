package org.study.netty.w3school;


import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * Created by ArnoldLee on 18/10/16.
 */
public class PlainOioServer {

    public static void server(int port) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(port);

         while(true){
             final Socket clientSocket = serverSocket.accept();
             System.out.println("Accepted connection from " + clientSocket);
             new Thread(new Runnable() {
                 @Override
                 public void run() {
                     OutputStream out;
                     try {
                         out = clientSocket.getOutputStream();
                         out.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));
                         out.flush();
                         clientSocket.close();
                     }
                     catch (IOException e) {
                         e.printStackTrace();
                     }
                     finally {
                         try {clientSocket.close(); }
                         catch (IOException ex) {
                             // ignore on close
                         }
                     }
                 }
             }).start();

         }
    }

    public static void main(String[] args) throws IOException {
        server(8000);
    }


}
