package org.study.jvm;

/**
 * Created by ArnoldLee on 16/11/19.
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Exception e) {
            System.out.println("stack length:"+oom.stackLength);
            e.printStackTrace();
        }
    }

}
