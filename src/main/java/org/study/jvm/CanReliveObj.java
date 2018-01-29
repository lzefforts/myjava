package org.study.jvm;

/**
 * 对象的复活
 * Created by ArnoldLee on 17/10/31.
 */
public class CanReliveObj {

    public static CanReliveObj obj;

    @Override
    public String toString() {
        return "I am CanReliveObj";
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("CanReliveObj finalize called");
        obj=this;
    }

    public static void main(String[] args) throws InterruptedException {
        obj = new CanReliveObj();
        obj = null;
        System.gc();
        Thread.sleep(1000);
        if(obj==null){
            System.out.println("obj 是 null");
        }else{
            System.out.println("obj 可用");
        }

        System.out.println("第2次gc");
        obj=null;
        System.gc();
        Thread.sleep(1000);
        if(obj==null){
            System.out.println("obj 是 null");
        }else{
            System.out.println("obj 可用");
        }

    }
}
