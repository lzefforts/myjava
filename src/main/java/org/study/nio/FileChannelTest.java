package org.study.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

/**
 * Created by ArnoldLee on 18/9/8.
 */
public class FileChannelTest {

    public static void main(String[] args) {
//        char cal = 'm';
//        byte[] calByteArr = charToByte(cal);
//        System.out.println(calByteArr.length);
//
//        getDataFromChannelWriteToBuffer();
//        transferForm();
        transferTo();

    }

    public static void getDataFromChannelWriteToBuffer() {
        try {
            //            RandomAccessFile file = new RandomAccessFile("/Users/ArnoldLee/Desktop/testIo.txt","rw");
            FileInputStream file = new FileInputStream("/Users/ArnoldLee/Desktop/testIo.txt");
            FileChannel fileChannel = file.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(48);
//            CharBuffer charBuffer = CharBuffer.allocate(48);
            int bytesRead = fileChannel.read(buf);
            while (bytesRead != -1) {
                System.out.println("######Read " + bytesRead + "######");
                //把buffer从写模式切换到读模式
                buf.flip();

                while (buf.hasRemaining()) {
//                    System.out.println("#####position:"+buf.position()+",limit:"+buf.limit());
                    System.out.print(buf.get() + "$$");
                    System.out.print((char) buf.get());
                }
                System.out.println("###");
                //清空整个缓冲区
                buf.clear();
                buf.compact();
                bytesRead = fileChannel.read(buf);
            }
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static byte[] charToByte(char c) {
        byte[] b = new byte[2];
        b[0] = (byte) ((c & 0xFF00) >> 8);
        b[1] = (byte) (c & 0xFF);
        return b;
    }

    public static void transferForm() {
        try {
            RandomAccessFile fromFile = new RandomAccessFile("/Users/ArnoldLee/Desktop/testIo.txt", "rw");
            FileChannel      fromChannel = fromFile.getChannel();

            RandomAccessFile toFile = new RandomAccessFile("/Users/ArnoldLee/Desktop/nioTo.txt", "rw");
            FileChannel      toChannel = toFile.getChannel();

            long position = 0;
            long count = fromChannel.size()-100;
            System.out.printf("count:%d",count);

            toChannel.transferFrom(fromChannel,position, count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void transferTo() {
        try {
            RandomAccessFile fromFile = new RandomAccessFile("/Users/ArnoldLee/Desktop/nioTo.txt", "rw");
            FileChannel      fromChannel = fromFile.getChannel();

            RandomAccessFile toFile = new RandomAccessFile("/Users/ArnoldLee/Desktop/newNioTo.txt", "rw");
            FileChannel      toChannel = toFile.getChannel();

            long position = 0;
            long count = fromChannel.size()-100;
            System.out.printf("count:%d",count);

            fromChannel.transferTo(position, count,toChannel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
