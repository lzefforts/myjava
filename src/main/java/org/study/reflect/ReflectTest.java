package org.study.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by ArnoldLee on 17/1/21.
 */
public class ReflectTest {

    public static void main(String[] args) {

        System.out.println(getSimpleName(BaseClass.class));
        System.out.println(getCanoinalName(BaseClass.class));
        System.out.println(getModifiers(BaseClass.class));

        Field[] fields = getFields(BaseClass.class);
        for(Field field : fields){
            System.out.println(field.getName());
        }
    }

    public static String getSimpleName(Class clazz){
        return clazz.getSimpleName();
    }

    public static int getModifiers(Class clazz){
        return clazz.getModifiers();
    }

    public static String getCanoinalName(Class clazz){
        return clazz.getCanonicalName();
    }

    //获取本类的公有属性
    public static Field[] getPublibcFields(Class clazz){
        return clazz.getFields();
    }

    //获取本类的所有属性
    public static Field[] getFields(Class clazz){

        return clazz.getDeclaredFields();
    }

    //获取父类的属性
    public static Field[] getSuperFields(Class clazz){
        Class superClass = clazz.getSuperclass();
        if(superClass != null){
            return superClass.getDeclaredFields();
        }
        return null;
    }

    //获取本类的方法
    public static Method[] getMethods(Class clazz){
        return clazz.getDeclaredMethods();
    }

    //获取父类的方法
    public static Method[] getSuperMethods(Class clazz){
        Class superClass = clazz.getSuperclass();
        if(superClass != null){
            return superClass.getDeclaredMethods();
        }
        return null;
    }



}
