package org.study.spring.proxy.custom;

/**
 * 模拟jdk实现代理类Proxy
 * @author ArnoldLee
 * @date 18/11/10
 */
public class CusProxy{


    public static Object newProxyInstance(CusClassLoader loader,
                                          Class<?>[] interfaces,
                                          CusInvocationHandler h)
            throws IllegalArgumentException
    {

        //1.生成源代码



        //2.把源代码输出到磁盘,生成java文件

        //3.编译源代码,生成为class文件

        //4.将class文件的内容加载到jvm中

        //5.返回被代理后的代理对象



        return null;
    }
}
