package org.study.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by ArnoldLee on 18/9/5.
 */
public class OutputStreamTest {

    public static void main(String[] args) {
        try {
            OutputStream outputStream = new FileOutputStream("/Users/ArnoldLee/Desktop/testIo.txt");


            outputStream.write("machine write!haha!Welcome to China!We support The Silk Road Economic Belt and the 21st-century Maritime Silk Road!".getBytes());

            outputStream.flush();
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
