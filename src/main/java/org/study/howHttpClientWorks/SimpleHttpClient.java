package org.study.howHttpClientWorks;

import java.io.*;
import java.net.Socket;

/**
 * Created by ArnoldLee on 2019/4/13.
 */
class SimpleHttpClient {

    protected String name;
    private String tel;


    public SimpleHttpClient() {
        System.out.printf("###SimpleHttpClient###\n");
    }

    public static void main(String[] args) throws IOException {
        String url = "http://www.newsmth.net/nForum/#!article/GreenAuto/252921";

        //如果需要进行https的请求只需要换成如下一句（https的默认端口为443，http默认端口为80）
        //Socket socket = SSLSocketFactory.getDefault().createSocket("xxx", 443);
        Socket socket = new Socket("www.newsmth.net", 80);

        //获取输入流，即从服务器获取的数据
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //获取输出流，即我们写出给服务器的数据
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        //使用一个线程来进行读取服务器的响应
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    String line = null;
                    try {
                        while ((line = bufferedReader.readLine()) != null) {
                            byte[] bytes = line.getBytes("GBK");
                            System.out.println("recv : " + new String(bytes));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        bufferedWriter.write("GET /nForum/#article/GreenAuto/252921 HTTP/1.1\r\n");
        bufferedWriter.write("Host: www.newsmth.net\r\n\r\n");
        bufferedWriter.flush();

    }
}
