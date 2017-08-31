package org.study.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by ArnoldLee on 17/2/25.
 */
public class EnhancerDemo extends AbstractEnhanceDemo{
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(EnhancerDemo.class);
        enhancer.setCallback(new MethodInterceptorImpl());

        EnhancerDemo demo = (EnhancerDemo)enhancer.create();
        demo.test();
        demo.abMethod();
        demo.firstMethod();
        System.out.println(demo);
    }

    public void test(){
        System.out.println("EnhancerDemo test()...");
    }

    @Override
    public void abMethod() {
        System.out.println("EnhancerDemo abMethod()...");
    }

    private static class MethodInterceptorImpl implements MethodInterceptor{
        @Override
        public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            System.err.println("Before invoke "+method);
            Object result = methodProxy.invokeSuper(object,args);
            System.err.println("After invoke "+method);
            return result;
        }
    }

}
