package org.study.spring.delegate;

/**
 * Created by ArnoldLee on 18/11/19.
 */
public class DelegateTest {

    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher(new ExectorA());
        dispatcher.doing();

    }

}
