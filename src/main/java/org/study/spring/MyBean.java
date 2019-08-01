package org.study.spring;

import lombok.Data;

/**
 *
 * @author ArnoldLee
 * @date 18/3/14
 */
@Data
public class MyBean {

    private String testStr = "testStr";
    private String val = "哈哈哈";

    public static void main(String[] args) {
        MyBean myBean = new MyBean();
        System.out.println(myBean.getVal());
    }

}
