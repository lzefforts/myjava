package org.study.jvm;

import java.lang.ref.WeakReference;

/**
 * 弱引用的回收
 * 弱引用在jvm垃圾回收时,不管内存空间是否一样,都会直接回收
 * Created by ArnoldLee on 17/11/1.
 */
public class WeakRef {
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
        User user = new User(1,"geym");
        WeakReference<User> userSoftReference = new WeakReference<User>(user);
        user = null;

        System.out.println(userSoftReference.get());
        System.gc();
        System.out.println("After GC");
        System.out.println(userSoftReference.get());
    }


}
