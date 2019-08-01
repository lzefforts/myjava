package org.study.classLoad;

import org.study.PageTool;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ArnoldLee on 18/11/11.
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if(is == null){
                        return super.loadClass(name);
                    }

                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };


        try {
            Object obj = myLoader.loadClass("java.lang.Object");
//            System.out.println(PageTool.class.getClassLoader());
            System.out.println(obj.getClass().getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
