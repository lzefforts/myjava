package org.study.thread;

import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by ArnoldLee on 17/12/1.
 */
public class ConcurrentLinkedQueueDemo {

    public static void main(String[] args) {

        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

        queue.add("23");
        queue.add(123);
        queue.add(new Date());

        Iterator iterator = queue.iterator();
        while (iterator.hasNext()){
            Object object = iterator.next();
            System.out.println(object.toString());

        }


    }
}
