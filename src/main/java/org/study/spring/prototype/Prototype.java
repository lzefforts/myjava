package org.study.spring.prototype;

/**
 * Created by ArnoldLee on 18/11/20.
 */
public class Prototype implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
