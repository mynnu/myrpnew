package org.spoto.aop;

import org.aspectj.lang.JoinPoint;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AopStudy {
    //前置方法
    public void beforeStudy(JoinPoint joinPoint) throws Exception {
//        An an = hasAn(joinPoint);
//        if (an != null){
//            System.out.println("before study:Preview first!");
//        }
    }

    //后置方法
    public void afterStudy(JoinPoint joinPoint) throws Exception {
        An an = hasAn(joinPoint);
        if (an != null){
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            System.out.println("访问时间："+ formatter.format(date));
            System.out.println("提示信息：after study:Complete your homework on time!");
        }
    }

    //获取注解的方法            切点joinPoint
    public An hasAn(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class<?> targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class<?>[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    // B方法(method),返回的an要么有值要么是null
                    An an = method.getAnnotation(An.class);
                    return an;
                }
            }
        }
        return null;
    }

}
