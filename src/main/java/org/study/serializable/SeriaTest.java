package org.study.serializable;

import java.io.*;

/**
 * Created by ArnoldLee on 16/12/31.
 */
public class SeriaTest {

    private static class Inner implements Serializable{
        private static Long serialVersionUID = 1L;
        private String name;
        private String phone;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }

    private static class Outer implements Serializable{
        private static Long serialVersionUID = 1L;
        private String outerName;
        private String outerPhone;

        public String getOuterName() {
            return outerName;
        }

        public void setOuterName(String outerName) {
            this.outerName = outerName;
        }

        public String getOuterPhone() {
            return outerPhone;
        }

        public void setOuterPhone(String outerPhone) {
            this.outerPhone = outerPhone;
        }
    }


    public static void main(String[] args) {


    }

    public static void fan()//反序列的过程
    {
        ObjectInputStream oin = null;//局部变量必须要初始化
        try
        {
            oin = new ObjectInputStream(new FileInputStream("my.out"));
        } catch (FileNotFoundException e1)
        {
            e1.printStackTrace();
        } catch (IOException e1)
        {
            e1.printStackTrace();
        }
        Inner mts = null;
        try {
            mts = (Inner ) oin.readObject();//由Object对象向下转型为MyTest对象
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("name="+mts.name);
        System.out.println("phone="+mts.phone);
    }
}
