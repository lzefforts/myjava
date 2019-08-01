package org.study.reflect;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.esotericsoftware.reflectasm.PublicConstructorAccess;
import org.springframework.cglib.core.ReflectUtils;

public class ReflectAsmTest {
    private static int num = 1000000;

    private static SuperClass old;
    static {
        old = new SuperClass();
    }

    static void test(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            ConstructorAccess<SuperClass> access = PublicConstructorAccess.get(SuperClass.class);
            SuperClass bean = access.newInstance();
        }
        long end = System.currentTimeMillis();
        System.out.println("reflectAsm timeout=" + (end - start));
    }

    static void test1(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            try {
                Class clazz = Class.forName("org.study.reflect.SuperClass");
                SuperClass bean = (SuperClass)clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        long end = System.currentTimeMillis();
        System.out.println("reflect timeout=" + (end - start));
    }

    static void test2(){
        long start = System.currentTimeMillis();

        for (int i = 0; i < num; i++) {
            try {
                SuperClass bean = old.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("clone timeout=" + (end - start));
    }

    static void test3(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            SuperClass old = new SuperClass();
        }
        long end = System.currentTimeMillis();
        System.out.println("new timeout=" + (end - start));
    }

    static void test4(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            SuperClass bean = (SuperClass)ReflectUtils.newInstance(SuperClass.class);
        }
        long end = System.currentTimeMillis();
        System.out.println("ReflectUtils timeout=" + (end - start));
    }

    public static void main(String[] args) {
        test();
        test1();
        test2();
        test3();
        test4();
    }

}
