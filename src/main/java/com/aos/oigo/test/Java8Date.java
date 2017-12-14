package com.aos.oigo.test;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @Author : HuangHaoXin
 * @Description :JAVA8 日期时间
 * @Date : Create in 2017-10-23
 */
public class Java8Date
{
    @Test
    public void getDate()
    {
        //获取日期
        LocalDate today = LocalDate.now();
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyyMMdd");
        System.out.println(today.format(dt));
    }

    @Test
    public void getTime()
    {
        //获取时间
        LocalTime time = LocalTime.now();
        System.out.println(time);
    }

    @Test
    public void getClock()
    {
        Clock clock = Clock.systemUTC();
        System.out.println(clock);

        Clock clock1 = Clock.systemDefaultZone();
        System.out.println(clock1);
    }

    @Test
    public void getDateTime()
    {
        //获取当前时间戳
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);

        Instant timestamp = Instant.now();
        System.out.println(timestamp);
    }
}
