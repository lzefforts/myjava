package org.study.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ArnoldLee on 17/10/26.
 */
public class HashMapTest {

    public static void main(String[] args) {
        Map<String,Object> conditions = new HashMap<>();

        conditions.put("aaa","bbb");
        conditions.put("cc","ccc");
        conditions.put("dd","ddd");
        conditions.put("aaa","ddd");

        String aa = "Aa";
        String bb = "BB";
        System.out.println(aa.hashCode()+","+bb.hashCode());

    }
}
