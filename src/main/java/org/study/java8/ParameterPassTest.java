package org.study.java8;

/**
 * Created by ArnoldLee on 2019/5/26.
 */
public class ParameterPassTest {

    private String str = "hello";
    private int a = 20;

    private void foo(String str){
        str = "world";
    }

    public static void main(String[] args) {
        ParameterPassTest test = new ParameterPassTest();
        test.foo(test.str);
        System.out.println(test.str);
    }


}
