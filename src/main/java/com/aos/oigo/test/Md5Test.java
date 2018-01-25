package com.aos.oigo.test;

import com.aos.oigo.utils.MD5Util;

public class Md5Test
{
    public static void main(String[] args)
    {
        int price = 1000;
        String md5str = MD5Util.getMd5("123456" + price);
        System.out.println(md5str);
    }
}
