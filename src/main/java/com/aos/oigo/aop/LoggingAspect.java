package com.aos.oigo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author : HuangHaoXin
 * @Description : Aop Logger
 * @Date : Create in 2018-01-10
 */
@Aspect
@Component
public class LoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * 函数执行前
     *
     * @param jp
     * @param a
     * @param b
     */
    /*
    @Before("execution(* com.aos.oigo.service.Impl.*.*(..)) && args(a,b)")
    private void beforeDoLog(JoinPoint jp, int a, int b) {
        log.info("param1: " + a + ", param2: " + b);
        log.info("Before: " + jp.toString());
    }
    */

    /**
     * 函数正常返回后
     * returning : 定义参数从上下文得到返回值
     *
     * @param jp
     */
    /*
    @AfterReturning(pointcut = "execution(* com.aos.oigo.service.Impl.*.*(..))", returning = "returnVal")
    private void afterReturningDoLog(JoinPoint jp, Object returnVal) {
        log.info("AfterReturning Result Value: " + returnVal);
        log.info("AfterReturning: " + jp.toString());
    }
    */

    /**
     * 函数抛出异常后
     * throwing : 定义参数拿到异常信息
     *
     * @param jp
     * @param ex
     */
    /*
    @AfterThrowing(pointcut = "execution(* com.aos.oigo.service.Impl.*.*(..))", throwing = "ex")
    private void afterThrowingDoLog(JoinPoint jp, MathArithmeticException ex) {
        log.info("Exception Message: " + ex.getMessage());
        log.info("AfterThrowing: " + jp.toString());
    }

    */
    /**
     * 函数返回后
     *
     * @param jp
     */
    /*
    @After("execution(* com.aos.oigo.service.Impl.*.*(..))")
    private void afterDoLog(JoinPoint jp) {
        log.info("After: " + jp.toString());
    }
    */

    /**
     * 函数执行前后
     * 函数有返回值的方法
     * @param pjp
     * @return
     * @throws Throwable
     */
    /*
    @Around("execution(* com.aos.oigo.service.Impl.*.*(..))")
    private Object aroundDoLog(ProceedingJoinPoint pjp) throws Throwable {
        //log.info("Start Method: " + pjp.toString());
        Object value = pjp.proceed();
        //log.info("Stop Method: " + value);
        return value;
    }
    */

    /**
     * 函数执行前后
     * 函数无返回值的方法
     * @param pjp
     * @return
     * @throws Throwable
     */
    /*
    @Around("execution(* com.aos.oigo.service.Impl.*.*(..))")
    private void aroundNoReturnValDoLog(ProceedingJoinPoint pjp) throws Throwable {
        log.info("Start Method: " + pjp.toString());
        log.info("Stop Method: " + pjp.proceed());
    }
    */
}
