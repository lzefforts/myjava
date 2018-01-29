package org.study.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 内存占位符对象,一个OOMObject大约栈64K
 * Created by ArnoldLee on 17/12/30.
 */
public class OOMObject {


    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for(int i=0;i<num;i++){
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.out.println("开始gc...");
        System.gc();


    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }

}
