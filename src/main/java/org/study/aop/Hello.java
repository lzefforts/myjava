package org.study.aop;

/**
 * Created by ArnoldLee on 18/7/17.
 */
public class Hello {

    public void sayHello() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Hello h = new Hello();
        h.sayHello();
    }
}
