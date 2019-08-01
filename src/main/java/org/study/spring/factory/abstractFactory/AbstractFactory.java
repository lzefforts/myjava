package org.study.spring.factory.abstractFactory;

/**
 * Created by ArnoldLee on 18/11/27.
 */
public abstract class AbstractFactory {

    public abstract void dispaly();

    public void init(){
        System.out.println("init.....");
    }

}
