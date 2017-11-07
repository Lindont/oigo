package com.aos.oigo.test;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
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


    @Test
    public void getStringSSS()
    {
        SimpleDateFormat fmt = new SimpleDateFormat("SSS"); //获取毫秒
        String suffix = fmt.format(new Date());
        System.out.println(suffix);
    }

    @Test
    public void getTime4()
    {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("MM月dd日 HH点业绩更新：");
        String time = format.format(date);
        System.out.println(time);
    }

    @Test
    public void getTime5()
    {
        Date date = new Date();
        System.out.println(date.getMonth() + 1);
        System.out.println(date.getDate()-1);;
        System.out.println(date.getHours() + " : " + date.getMinutes());
        DateFormat dt = new SimpleDateFormat("HH");
        System.out.println(dt.format(date));
    }

    @Test
    public void test(){
        String time = "";
        Date date = new Date();
        DateFormat dt = new SimpleDateFormat("HH");
        if ("00".equals(dt.format(date))) {
            time = (date.getMonth() + 1) + "月" + (date.getDate() - 1) + "日24点业绩更新:";
        } else {
            time = (date.getMonth() + 1) + "月" + (date.getDate() - 1) + "日24点业绩更新:";
           // time = new SimpleDateFormat("MM月dd日 HH点业绩更新:").format(date);
        }

        System.out.println(time);
    }

    @Test
    public void formatTime()
    {
        String str = "201791190538";
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        try
        {
            System.out.println(sf.parse(str));
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
    }
}
