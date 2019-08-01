package org.study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by ArnoldLee on 18/9/10.
 */
public class NIOServer {

    public static void main(String[] args) {
        try {
            Selector serverSelector = Selector.open();
            Selector clientSelector = Selector.open();

            new Thread(()->{
                try {
                    ServerSocketChannel listenerChannel = ServerSocketChannel.open();
                    listenerChannel.socket().bind(new InetSocketAddress(8090));
                    listenerChannel.configureBlocking(false);
                    listenerChannel.register(serverSelector, SelectionKey.OP_ACCEPT);
                    while (true){
                        if(serverSelector.select(1) > 0){
                            Set<SelectionKey> set = serverSelector.keys();
                            Iterator<SelectionKey> keyIterator = set.iterator();
                            while(keyIterator.hasNext()){
                                SelectionKey key = keyIterator.next();
                                if(key.isAcceptable()){

                                }
                            }



                        }
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
