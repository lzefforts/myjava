package org.study.thread;

/**
 * Created by ArnoldLee on 17/9/20.
 */
public class OrderExample {
    int a = 0;
    boolean flag = false;
    public void writer(){
        a = 1;
        flag = true;
    }
    public void reader(){
        if(flag){
            int i = a+1;
            System.out.println(i);
        }
    }

}
