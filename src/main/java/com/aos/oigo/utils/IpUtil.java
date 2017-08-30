package com.aos.oigo.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取IP地址工具类 By 黄浩新 2018-08-18
 */


public class IpUtil
{
    public static String getInternetIp(HttpServletRequest request)
    {
        String ip = request.getHeader("x-forwarded-for");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getRemoteAddr();
        }

        if (ip != null && ip.indexOf(",") > 0)
        {
            ip = ip.substring(0, ip.indexOf(","));
        }

        return ip;
    }
}
