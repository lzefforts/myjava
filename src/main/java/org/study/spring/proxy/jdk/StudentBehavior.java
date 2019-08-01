package org.study.spring.proxy.jdk;

/**
 * Created by ArnoldLee on 18/11/10.
 */
public class StudentBehavior implements PersonBehavior {
    @Override
    public void display() {
        System.out.println("I am a student!");
    }
}
