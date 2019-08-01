package org.study.spring.factory;

import org.study.cglib.CglibUtil;

/**
 * Created by ArnoldLee on 18/11/27.
 */
public class FactoryTest {

    public static void main(String[] args) {


        Factory bean = (Factory)new CglibUtil().createProxy(IbmNoteBook.class);
        bean.display();
    }
}
