package org.study.spring.factory;

/**
 * Created by ArnoldLee on 18/11/27.
 */
public class IbmNoteBook implements Factory {
    @Override
    public void display() {
        System.out.println("########IbmNoteBook##########");
    }
}
