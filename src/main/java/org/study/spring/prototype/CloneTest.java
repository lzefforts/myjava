package org.study.spring.prototype;

/**
 * Created by ArnoldLee on 18/11/20.
 */
public class CloneTest {

    public static void main(String[] args) {

        ConcretePrototype cp = new ConcretePrototype();
        cp.setAge("123");
        try {
            ConcretePrototype copy = (ConcretePrototype)cp.clone();
            String age = copy.getAge();
            System.out.printf("############ %s",age);

            System.out.println();
            ConcretePrototype test = cp;
            System.out.printf("############ %s,%s,%s",cp,copy,test);

            Integer a = 234;
            Integer b = 234;
            System.out.printf("############ %s",(a.equals(b)));

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
