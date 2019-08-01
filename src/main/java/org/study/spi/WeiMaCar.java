package org.study.spi;


/**
 * Created by ArnoldLee on 2019/1/12.
 */
//@AutoService(Processor.class)
public class WeiMaCar implements ICard {
    @Override
    public void display() {
        System.out.println("#####WeiMaCar#######");
    }
}
