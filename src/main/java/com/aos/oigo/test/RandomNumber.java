package com.aos.oigo.test;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2017-10-16
 */
public class RandomNumber
{
    /**
     * 随机生成一组数组
     * @return
     */
    public static int[] getRanDomNum()
    {
        //生成大于10的随机数
        int n = getNumber() + 10;
        //初始化数组
        int[] m = new int[n];
        for (int i = 0; i < m.length; i++)
        {
            //生成随机数并存入数组
            m[i] = getNumber();
        }
        return m;
    }

    /**
     * 随机生成一个整数
     * @return
     */
    public static int getNumber()
    {
        return (int) (Math.random() * 10000);
    }
}

