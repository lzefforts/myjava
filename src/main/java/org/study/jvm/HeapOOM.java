package org.study.jvm;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ArnoldLee on 16/11/18.
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new LinkedList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
