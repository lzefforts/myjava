package org.study.jdk;

public abstract class IntegerTest {

    public static void main(String[] args) {
        int a = 123;
        Integer b = new Integer(123);
        Integer c = new Integer(123);
        {
            boolean result = b.equals(a);
            System.out.println(result);
        }
        {
            boolean result = b.equals(c);
            System.out.println(result);
        }
    }
}
