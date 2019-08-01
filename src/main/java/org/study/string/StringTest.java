package org.study.string;

/**
 * Created by ArnoldLee on 18/6/14.
 */
public class StringTest {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = "a" + "bc";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
    }



}
