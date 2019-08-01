package org.study.howHttpClientWorks;

/**
 * Created by ArnoldLee on 2019/4/14.
 */
public class Test extends ParentClass{

    public Test() {
        super();
        System.out.printf("test\n");
    }

    public static void main(String[] args) {
//        SimpleHttpClient client = new SimpleHttpClient();
        Test test = new Test();
    }
}
