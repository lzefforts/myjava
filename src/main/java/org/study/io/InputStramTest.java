package org.study.io;

import java.io.*;

/**
 * Created by ArnoldLee on 18/9/4.
 */
public class InputStramTest {

    public static void main(String[] args) {
//        test();

        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream("/Users/ArnoldLee/Desktop/testIo.txt"));
            byte[] data = new byte[14];
            int flag = inputStream.read(data);
            System.out.println();
            while(-1 != flag){
                flag = inputStream.read(data);
                inputStream.mark(5);
            }
            System.out.println("file read over!");

            inputStream.reset();
//            inputStream.read(data);
            System.out.println("######mark.....rest......");
            System.out.println("######string:"+new String(data)+"#####");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void test(){
        String content = "BoyceZhang!";
        InputStream inputStream = new ByteArrayInputStream(content.getBytes());

        // 判断该输入流是否支持mark操作
        if (!inputStream.markSupported()) {
            System.out.println("mark/reset not supported!");
        }
        int ch;
        boolean marked = false;
        try {
            while ((ch = inputStream.read()) != -1) {

                //读取一个字符输出一个字符
                System.out.print((char)ch);
                //读到 'e'的时候标记一下
                if (((char)ch == 'e')& !marked) {
                    inputStream.mark(content.length());  //先不要理会mark的参数
                    marked = true;
                }

                //读到'!'的时候重新回到标记位置开始读
                if ((char)ch == '!' && marked) {
                    inputStream.reset();
                    marked = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //程序最终输出：BoyceZhang!Zhang!


    }
}
