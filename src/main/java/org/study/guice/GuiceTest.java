package org.study.guice;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

/**
 *
 * @author ArnoldLee
 * @date 18/9/7
 */
@Singleton
public class GuiceTest {

    @Inject
    GuiceBean guiceBean;

    public void test(){
        System.out.println(guiceBean);
        guiceBean.display();
    }


    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        IGuiceOperator feMaleOperator = injector.getInstance(GuiceFeMaleOperator.class);
        feMaleOperator.display();


        IGuiceOperator manOperator = injector.getInstance(GuiceManOperator.class);
        manOperator.display();


    }



}
