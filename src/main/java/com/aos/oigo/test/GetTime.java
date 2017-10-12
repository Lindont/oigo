package com.aos.oigo.test;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2017-09-18
 */
public class GetTime
{
    @Test
    public void getTime()
    {
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(date);
        System.out.println(time);
    }

    @Test
    public void getStringTime()
    {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS"); //精确到毫秒
        String suffix = fmt.format(new Date());
        System.out.println(suffix);
    }

    @Test
    public void getTime2()
    {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("MM月dd日 HH点业绩更新：（当日0点至HH点）");
        String time = format.format(date);
        System.out.println(time);
    }

    @Test
    public void getTime3()
    {
        Date date = new Date();
        System.out.println(date.getHours());;
    }
}
