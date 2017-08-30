package com.aos.oigo.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Cookie工具类  By 黄浩新 2017-08-18
 */


public class CookieUtil
{
    /**
     * 设置Cookie
     *
     * @param response
     * @param name
     * @param value
     */
    public static void setCookie(HttpServletResponse response, String name, String value)
    {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 设置Cookie
     *
     * @param response
     * @param name
     * @param value
     * @param timeOut  有效时长
     */
    public static void setCookie(HttpServletResponse response, String name, String value, int timeOut)
    {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        if (timeOut>0)
        {
            cookie.setMaxAge(timeOut);
        }
        response.addCookie(cookie);
    }

    /**
     * 设置Cookie
     *
     * @param response
     * @param name
     * @param value
     * @param timeOut  有效时长
     * @param doMain   有效域
     */
    public static void setCookie(HttpServletResponse response, String name, String value, int timeOut, String doMain)
    {
        Cookie cookie = new Cookie(name, value);
        cookie.setDomain(doMain);
        cookie.setPath("/");
        cookie.setMaxAge(timeOut);
        response.addCookie(cookie);
    }

    /**
     * 获取Cookie对象
     *
     * @param request
     * @param name
     * @return
     */
    public static Cookie getCookie(HttpServletRequest request, String name)
    {
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(name))
        {
            return cookieMap.get(name);
        }
        return null;
    }

    /**
     * 获取Cookie的key
     *
     * @param request
     * @param name
     * @return
     */
    public static String getCookieName(HttpServletRequest request, String name)
    {
        Cookie cookie = getCookie(request, name);
        String cookieName = (cookie == null) ? null : cookie.getName();
        return cookieName;
    }

    /**
     * 获取Cookie的value
     *
     * @param request
     * @param name
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String name)
    {
        Cookie cookie = getCookie(request, name);
        String cookieValue = (cookie == null) ? null : cookie.getValue();
        return cookieValue;
    }

    /**
     * 删除Cookie
     *
     * @param response
     * @param name
     */
    public static void removeCookie(HttpServletResponse response, String name)
    {
        Cookie cookie = new Cookie(name, "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    /**
     * 遍历所有Cookie
     *
     * @param request
     * @return
     */
    public static Map<String, Cookie> readCookieMap(HttpServletRequest request)
    {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
        {
            for (Cookie cookie : cookies)
            {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}
