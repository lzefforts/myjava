package org.study.jvm;

import java.lang.ref.SoftReference;

/**
 * 强引用,软引用
 * Created by ArnoldLee on 17/10/31.
 */
public class SoftRef {

    public static class User{
        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int id;
        public String name;

        @Override
        public String toString() {
            return "[id="+String.valueOf(id)+",name="+name+"]";
        }
    }


    public static void main(String[] args) {
        User user = new User(1,"geym");//强引用
        SoftReference<User> userSoftReference = new SoftReference<User>(user);//软引用
        user = null;

        System.out.println(userSoftReference.get());
        System.gc();
        System.out.println("After GC");
        System.out.println(userSoftReference.get());

        byte[] b = new byte[1024*925*7];
        System.gc();//预期是通过gc把user给回收掉,结果直接报堆溢出的异常了
        System.out.println(userSoftReference.get());
    }
}
