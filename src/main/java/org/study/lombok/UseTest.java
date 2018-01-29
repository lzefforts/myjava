package org.study.lombok;

/**
 * Created by ArnoldLee on 17/8/31.
 */
public class UseTest {

    public static void main(String[] args) {
        ShowVo showVo = new ShowVo();

        showVo.setName("hahahah");

        System.out.println(showVo.getName());

        Dummy d = new Dummy();
        HelloWorldProcessor processor = new HelloWorldProcessor();
    }
}
