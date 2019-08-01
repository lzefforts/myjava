package org.study.jdk;

import java.math.MathContext;

/**
 * Created by ArnoldLee on 2019/6/10.
 */
public class MathContextTest {


    public static void main(String[] args) {
        MathContext mathContext = new MathContext("precision=2.345");
        int result = mathContext.getPrecision();
        System.out.println(result);
    }
}
