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
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(today.format(dt));
    }

    @Test
    public void getTime()
    {
        //获取时间
        LocalTime time = LocalTime.now();
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(time.format(dt));
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dtf.format(dt));

        Instant timestamp = Instant.now();
        System.out.println(timestamp);
    }
}
