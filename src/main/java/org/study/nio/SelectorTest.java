package org.study.nio;

import java.io.IOException;
import java.nio.channels.Selector;

/**
 * Created by ArnoldLee on 18/9/8.
 */
public class SelectorTest {

    public static void main(String[] args) {

        test();
    }

    public static void test() {
        try {
            Selector selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
