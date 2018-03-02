package org.study.thread;

/**
 * Created by ArnoldLee on 18/2/28.
 */
public final class PCData {


    private final int intData;

    public PCData(int intData) {
        this.intData = intData;
    }

    public int getIntData() {
        return intData;
    }

    @Override
    public String toString() {
        return "data:"+intData;
    }
}
