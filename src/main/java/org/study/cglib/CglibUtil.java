package org.study.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib代理工具类
 * @author ArnoldLee
 * @date 18/8/23
 */
public class CglibUtil<T> {

    private static Enhancer enhancer = new Enhancer();
    public CglibUtil() {
        System.out.println(enhancer.toString());
    }

    public T createProxy(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new MethodInterceptorImpl());
        T proxyBean = (T)enhancer.create();
        return proxyBean;
    }

    private static class MethodInterceptorImpl implements MethodInterceptor {
        @Override
        public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            Object result = methodProxy.invokeSuper(object,args);
            return result;
        }
    }

}
