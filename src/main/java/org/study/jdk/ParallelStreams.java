package org.study.jdk;

import java.util.Arrays;
import java.util.List;

public class ParallelStreams {


    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","2","3","4");
        list.stream().forEach(str->{
            System.out.println(str);
        });


    }

}
