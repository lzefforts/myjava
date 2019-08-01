package org.study.spring.greatestsage;

import java.io.Serializable;

/**
 * 金箍棒
 * Created by ArnoldLee on 18/11/21.
 */
public class GoldRingedStaff implements Serializable{

    private float height = 100;//长度
    private float diameter = 10;//直径

    //金箍棒变大
    public void grow(){
        this.height *= 2;
        this.diameter *= 2;
    }

    //金箍棒变小
    public void shrink(){
        this.height /= 2;
        this.diameter /= 2;
    }


}
