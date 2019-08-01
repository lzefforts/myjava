package org.study.cglib;

/**
 * Created by ArnoldLee on 18/8/23.
 */
public class MoNiTest {

    public static FatherClass getInstance(){
        FatherClass proxyBean = (FatherClass)new CglibUtil().createProxy(FatherClass.class);
        proxyBean.display();
        return proxyBean;
    }

    public static void main(String[] args) {
        getInstance();
    }


}
