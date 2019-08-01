package org.study.java8;

import org.apache.commons.lang.StringUtils;

import java.util.Optional;

/**
 * Created by ArnoldLee on 18/4/13.
 */
public class OptionalTest {

    public static void main(String[] args) {
        String str = null;
        String out = "123";
        if(StringUtils.isEmpty(str)){
            System.out.println("isEmpty");
        }
        if(Optional.ofNullable(str).isPresent()){
            System.out.println("empty");
        }
        if(Optional.ofNullable(out).isPresent()){
            System.out.println(out);
        }


        String value = "false";
        Boolean test = Boolean.parseBoolean(value);
        System.out.println(test.booleanValue());
    }

}
