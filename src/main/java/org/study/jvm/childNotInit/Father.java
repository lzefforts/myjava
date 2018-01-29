package org.study.jvm.childNotInit;

/**
 * Created by ArnoldLee on 18/1/7.
 */
public class Father {

    public static String m = "hello";

    static {
        System.out.println("父类初始化");
    }
}
