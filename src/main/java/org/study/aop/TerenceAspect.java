package org.study.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by ArnoldLee on 18/7/17.
 */
@Aspect
public class TerenceAspect {
    @Pointcut("execution(*org.study.aop.**(..))")
    public void pointcut(){
        System.out.println("########pointcut##########");
    }

    @Pointcut("within(org.study.aop.*)")
    public void bizPointcut(){
        System.out.println("########bizPointcut##########");
    }

}
