package com.aos.oigo.common.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2017-12-21
 */
public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext appCtx;

    /**
     * 此方法可以把ApplicationContext对象注入到当前类中作为一个静态成员变量。
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appCtx = applicationContext;
    }

    /**
     * 这是一个便利的方法，帮助我们快速得到一个Bean
     */
    public static Object getBean(String beanName) {
        return appCtx.getBean(beanName);
    }
}
