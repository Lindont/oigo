package com.aos.oigo.quarzt;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author : HuangHaoXin
 * @Description : 任务调度作业
 * @Date : Create in 2017-12-20
 */
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        /**
         * 编写具体的业务逻辑
         */
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Job：" + dt.format(df));
        System.out.println("黄浩新很帅 ！");
    }
}
