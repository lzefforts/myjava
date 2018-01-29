package org.study.jvm.childNotInit;

/**
 * Created by ArnoldLee on 18/1/7.
 */
public class Child extends Father{

    static {
        System.out.println("子类初始化");
    }
}
