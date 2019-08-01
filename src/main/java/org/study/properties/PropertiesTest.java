package org.study.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ArnoldLee on 2019/4/1.
 */
public class PropertiesTest {

    static int flag = 0;
    static {
        flag = 12;
        System.out.printf("static....\n");
    }


    public static void main(String[] args) {
        new PropertiesTest().readProperties();
        new PropertiesTest().readProperties();
        new PropertiesTest().readProperties();
    }

    public void readProperties(){
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("properties/sms.properties");
        Properties p = new Properties();
        try {
            p.load(in);
            for(String key : p.stringPropertyNames()){
                System.out.printf("key:%s\n",key);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
