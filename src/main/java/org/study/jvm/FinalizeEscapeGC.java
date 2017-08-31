package org.study.jvm;

/**
 * 此代码演示了两点:
 * 1.对象可以在被GC的时候自我拯救(通过覆盖finalize方法)
 * 2.这种自救的机会只有一次,因为一个对象的finalize方法最多只会被系统自动调用一次
 *
 * Created by ArnoldLee on 17/5/20.
 */
public class FinalizeEscapeGC {


    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yes,i am staill alive :) ");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次拯救自己
        SAVE_HOOK = null;
        System.gc();
        //由于finalize方法优先级别低,所以暂停0.5秒,等待它
        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no,i am dead :( ");
        }

        //再进行一次GC,这次对象的自我拯救失败
        SAVE_HOOK = null;
        System.gc();
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no,i am dead :( ");
        }


    }

}
