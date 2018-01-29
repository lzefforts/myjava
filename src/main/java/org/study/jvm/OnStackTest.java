package org.study.jvm;

/**
 *  栈上对象逃逸测试
 * Created by ArnoldLee on 17/10/26.
 */
public class OnStackTest {

    public static class User{
        public int id=0;
        public String name="";
    }

    public static void alloc(){
        User u = new User();
        u.id=5;
        u.name="geym";
    }

    public static void main(String[] args) {
        long b = System.currentTimeMillis();
        for(int i=0;i<100000000;i++){
            alloc();
        }
        long e = System.currentTimeMillis();
        System.out.println("耗时为:"+(e-b));
    }


}
