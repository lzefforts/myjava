package org.study.jvm;

/**
 * 堆内存测试
 * Created by ArnoldLee on 17/10/31.
 */
public class HeapAlloc {

    public static void main(String[] args) {
        System.out.print("maxMemory=");
        System.out.println(Runtime.getRuntime().maxMemory()+" bytes");
        System.out.print("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory()+" bytes");
        System.out.print("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory()+" bytes");

        byte[] b = new byte[1*1024*1024];
        System.out.println("分配了1M空间给数组");
        System.out.print("maxMemory=");
        System.out.println(Runtime.getRuntime().maxMemory()+" bytes");
        System.out.print("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory()+" bytes");
        System.out.print("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory()+" bytes");

        b = new byte[4*1024*1024];
        System.out.println("分配了4M空间给数组");
        System.out.print("maxMemory=");
        System.out.println(Runtime.getRuntime().maxMemory()+" bytes");
        System.out.print("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory()+" bytes");
        System.out.print("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory()+" bytes");

    }



}
