package org.study.jvm.childNotInit;

/**
 *  对于静态字段，只有直接定义这个字段的类才会被初始化，
 *  因此，通过其子类来引用父类中定义的静态字段，
 *  只会触发父类的初始化而不会触发子类的初始化。
 *
 * Created by ArnoldLee on 18/1/7.
 */
public class StaticTest {


    public static void main(String[] args) {
        System.out.println(Child.m);
    }
}
