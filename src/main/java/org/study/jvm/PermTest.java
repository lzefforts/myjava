package org.study.jvm;

import java.util.HashMap;

/**
 * 方法区测试
 * Created by ArnoldLee on 17/10/26.
 */
public class PermTest {

    public static void main(String[] args) {
        int i = 0;
        try {
            for(i=0;i<90000000;i++){
                CglibBean bean = new CglibBean(new HashMap<>());
            }
            System.out.println("######total count:"+i);
        } catch (Exception e) {
            System.out.println("exception total count:"+i);
        }
    }
}
