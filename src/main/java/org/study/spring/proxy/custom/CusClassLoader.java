package org.study.spring.proxy.custom;

/**
 * Created by ArnoldLee on 18/11/10.
 */
public class CusClassLoader extends ClassLoader{

    public CusClassLoader() {
        System.out.println("loading CusClassLoader...");
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
