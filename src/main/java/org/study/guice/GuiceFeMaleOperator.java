package org.study.guice;

import com.google.inject.Singleton;

/**
 * Created by ArnoldLee on 18/9/7.
 */
@Singleton
public class GuiceFeMaleOperator implements IGuiceOperator {
    @Override
    public void display() {
        System.out.println("GuiceFeMaleOperator");
    }
}
