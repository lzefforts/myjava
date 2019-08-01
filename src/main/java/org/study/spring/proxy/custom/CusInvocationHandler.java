package org.study.spring.proxy.custom;

import java.lang.reflect.Method;

/**
 * 模拟jdk动态代理接口
 *
 * @author ArnoldLee
 * @date 18/11/10
 */
public interface CusInvocationHandler {


    Object invoke(Object target, Method method, Object[] args) throws Throwable;
}
