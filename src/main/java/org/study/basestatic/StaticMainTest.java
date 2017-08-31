package org.study.basestatic;

import java.util.Date;

/**
 * Created by ArnoldLee on 17/5/7.
 */
public class StaticMainTest {

    public static void main(String[] args) {
        StaticTest staticTest01 = new StaticTest();
        StaticTest staticTest02 = new StaticTest();
        staticTest01.changeMap("123");
        staticTest01.getMap();
        staticTest02.changeMap("234");
        staticTest02.getMap();


        Date beginTime = new Date();
        System.out.println("begin:"+beginTime.getTime());

        int a = 0;

        for(int i=1;i<=1000000;i++){
            a +=i;
        }

        Date endTime = new Date();
        System.out.println(a);
        System.out.println("spend:"+(endTime.getTime()-beginTime.getTime()));
    }
}
