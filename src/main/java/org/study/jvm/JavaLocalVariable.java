package org.study.jvm;

/**
 * Created by ArnoldLee on 17/10/26.
 */
public class JavaLocalVariable {


    public void localvarGc1(){
        byte[] a = new byte[6*1024*1024];
        System.gc();
    }

    public void localvarGc2(){
        byte[] a = new byte[6*1024*1024];
        a = null;
        System.gc();
    }

    public void localvarGc3(){
        {
            byte[] a = new byte[6*1024*1024];
        }
        System.gc();
    }

    public void localvarGc4(){
        {
            byte[] a = new byte[6*1024*1024];
        }
        int c = 10;
        System.gc();
    }

    public void localvarGc5(){
        localvarGc1();
        System.gc();
    }

    public static void main(String[] args) {
        JavaLocalVariable variable = new JavaLocalVariable();
        variable.localvarGc4();
    }

}
