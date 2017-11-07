package com.aos.oigo.test;

import org.junit.Test;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2017-10-30
 */
public class StringDemo
{
    @Test
    public void SubPd()
    {
        //截取PD_ID
        String str = "JFDHIGUHIUFNGIUJHPD_NO:000286LJMDFSGIUYUHNHNEWUYGYU475146548";
        String pd = str.substring(str.indexOf("PD_NO")+6, str.indexOf("PD_NO")+12);
        System.out.println(pd);
    }

    @Test
    public void SubMd()
    {
        //截取MD_ID
        String str = "SH_NO:000223,PD_NO:000286,SH_NO:000537,MD_NO:000146";
        String md = str.substring(str.indexOf("MD_NO")+6, str.indexOf("MD_NO")+12);
        System.out.println(md);
    }

    @Test
    public void test1()
    {
        String str = "{\"title\":\"领奖通知\",\"description\":\"Hello\",\"url\":\"http://www.baidu.com\",\"btntxt\":\"Hi\"}";
    }

    @Test
    public void test2()
    {
        String d = "2017-9-9";
        String str = "83042";
        System.out.println(str.substring(0,1)+":"+str.substring(1,3)+":"+str.substring(3,5));
        String str2 = "183042";
        System.out.println(str2.substring(0,2)+":"+str2.substring(2,4)+":"+str2.substring(4,6));
    }
}
