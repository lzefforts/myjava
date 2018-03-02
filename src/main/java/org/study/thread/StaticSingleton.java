package org.study.thread;

/**
 * 单例类,支持并发,且性能较为优良
 * 巧妙的运用了内部类的类加载机制
 * 内部类只在第一次使用时才会被加载
 *
 *
 * @author ArnoldLee
 * @date 18/2/27
 */
public class StaticSingleton {

    private StaticSingleton() {
        System.out.println("StaticSingleton is create!");
    }

    private static class SingletonHolder{
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
        return SingletonHolder.instance;
    }

}
