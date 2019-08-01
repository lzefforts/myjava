package org.study.spring.delegate;

/**
 * Created by ArnoldLee on 18/11/19.
 */
public class Dispatcher implements IExector {

    IExector exector;

    public Dispatcher(IExector exector) {
        this.exector = exector;
    }

    @Override
    public void doing() {
        this.exector.doing();
    }
}
