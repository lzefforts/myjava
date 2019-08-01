package org.study.spring.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ArnoldLee on 18/11/10.
 */
public class AgencyBehaviorProxy implements InvocationHandler {

    private PersonBehavior target;
    public Object getInstance(PersonBehavior target){
        this.target = target;
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        this.target.display();
        method.invoke(this.target,args);
        return null;
    }
}
