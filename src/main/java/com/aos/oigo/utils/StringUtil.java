package com.aos.oigo.utils;

/**
 * @author 黄浩新
 * @since 2017-7-21
 */

public class StringUtil
{
    public static boolean notNullorBlank(String str)
    {
        if (str != null || str != "")
        {
            return true;
        }
        return false;
    }


    public static boolean isNullorBlank(String str)
    {
        if (str == null || str == "")
        {
            return true;
        }
        return false;
    }


}
