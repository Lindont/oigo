package com.aos.oigo.quarzt;

import org.quartz.SchedulerException;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2017-12-20
 */
public class QuartzApp {
    public static void main(String[] args) throws SchedulerException {
        HelloScheduler hs = new HelloScheduler();
        //hs.testSimpleTrigger();
        hs.testCronTrigger();
    }
}
