package com.aos.oigo.test;

import com.aos.oigo.utils.MD5Util;

public class Md5Test
{
    public static void main(String[] args)
    {
        String md5str = MD5Util.getMd5("111111");
        System.out.println(md5str);
    }
}
