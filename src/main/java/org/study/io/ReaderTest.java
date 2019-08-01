package org.study.io;

import java.io.*;

/**
 * Created by ArnoldLee on 18/9/6.
 */
public class ReaderTest {

    public static void main(String[] args) {
        try {
//            Reader reader = new InputStreamReader(new FileInputStream("/Users/ArnoldLee/Desktop/testIo.txt"),"utf-8");
            Reader reader = new FileReader("/Users/ArnoldLee/Desktop/testIo.txt");
            char[] data      = new char[1024];
            System.out.print("before:");
            for (char byted:data) {
                System.out.print(byted);
            }
            System.out.println();
            if(-1 == reader.read(data)){
                System.out.println("file read over!");
            }
            System.out.print("after:");
            for (char byted:data) {
                System.out.print(byted);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
