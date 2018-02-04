package com.aos.oigo.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author : HuangHaoXin
 * @Description : quartz 任务调度类
 * @Date : Create in 2017-12-20
 */
public class HelloScheduler {

    public void testSimpleTrigger() throws SchedulerException {
        //在Scheduler里创建一个JobDetail实例，将该实例与Hello Job Class绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "JobGroup1").build();

        System.out.println("JobDetail's name：" + jobDetail.getKey().getName());
        System.out.println("JobDetail's group：" + jobDetail.getKey().getGroup());
        System.out.println("JobDetail's jobClass：" + jobDetail.getJobClass().getName());


        /**
         * SimpleTrigger
         */
        //创建一个Trigger实例 , 定义开始执行时间，重复执行时间，重复执行次数
        SimpleTrigger simpleTrigger = (SimpleTrigger) TriggerBuilder
                .newTrigger()
                .withIdentity("simpleTrigger", "TriggerGroup1")
                .startNow() //立即开始执行
                //.startAt(Date) 设置执行时间
                //.endAt(Date) 设置结束时间
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(3) //间隔3秒执行一次
                        //.withRepeatCount(3) //重复3次
                        //.withRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY) //重复无限次
                        .repeatForever()) //重复无限次
                .build();

        //创建 Schedule 实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("SimpleTrigger开启时间：" + dt.format(df));

        scheduler.scheduleJob(jobDetail, simpleTrigger);
    }


    public void testCronTrigger() throws SchedulerException {
        //在Scheduler里创建一个JobDetail实例，将该实例与Hello Job Class绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "JobGroup2").build();

        System.out.println("JobDetail's name：" + jobDetail.getKey().getName());
        System.out.println("JobDetail's group：" + jobDetail.getKey().getGroup());
        System.out.println("JobDetail's jobClass：" + jobDetail.getJobClass().getName());

        /**
         * CronTrigger
         */
        CronTrigger cronTrigger = (CronTrigger) TriggerBuilder.newTrigger()
                .withIdentity("cronTrigger", "TriggerGroup2").withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ? *")).build();

        //创建 Schedule 实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        //scheduler.standby();  //挂起 - 可重启
        //scheduler.shutdown();  //停止 - 不可重启  可传入参数 true(等待任务执行完再停止)/false(立即停止)

        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("CronTrigger开启时间：" + dt.format(df));

        scheduler.scheduleJob(jobDetail, cronTrigger);
    }
}
