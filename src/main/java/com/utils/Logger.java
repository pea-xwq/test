package com.utils;

import org.aspectj.lang.ProceedingJoinPoint;

//用于记录日志的工具类，提供公共代码
public class Logger {

    //前置通知
    public void beforePrintLog(){
        System.out.println("前置通知Logger类中的beforePrintLog开始记录日志了");
    }
    //后置通知
    public void afterReturningprintLog(){
        System.out.println("后置通知Logger类中的afterReturningprintLog开始记录日志了");
    }
    //异常通知
    public void afterThrowingPrintLog(){
        System.out.println("异常通知Logger类中的afterThrowingPrintLog开始记录日志了");
    }
    //最终通知
    public void afterPrintLog(){
        System.out.println("最终通知Logger类中的afterPrintLog开始记录日志了");
    }

    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue=null;
        try{
            Object[] args = pjp.getArgs();
            System.out.println("环绕通知 前置");
            rtValue = pjp.proceed(args);
            System.out.println("环绕通知 后置");
            return rtValue;
        }catch(Throwable t){
            System.out.println("环绕通知 异常");
            throw new RuntimeException(t);
        }finally{
            System.out.println("环绕通知 最终");
        }


    }
}
