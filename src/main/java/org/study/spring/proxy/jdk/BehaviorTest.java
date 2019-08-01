package org.study.spring.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * Created by ArnoldLee on 18/11/10.
 */
public class BehaviorTest {


    public static void main(String[] args) {
        PersonBehavior p = (PersonBehavior)new AgencyBehaviorProxy().getInstance(new TeacherBehavior());
        System.out.println(p.getClass().getName());
        p.display();

    }
}
