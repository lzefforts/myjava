package org.study.nio;

import java.nio.ByteBuffer;
import java.nio.channels.Channel;

/**
 * Created by ArnoldLee on 18/9/2.
 */
public class BufferTest {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(48);
        String str = new String("hello world!");
        buffer = ByteBuffer.wrap(str.getBytes());
        buffer.put(0,new Byte("1"));

//        int bytesRead = inChannel.read(buffer);
//
//        while(! bufferFull(bytesRead) ) {
//            bytesRead = inChannel.read(buffer);
//        }
        int i = 0;
        do{
            System.out.println(buffer.get(i));
            i++;
        }
        while(i< buffer.limit());
    }

}
