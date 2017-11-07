package com.aos.oigo.test;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2017-10-13
 */
public class MyThread extends Thread
{
    @Override
    public void run()
    {
        for (int i = 0 ; i<100 ; i++)
        {
            System.out.println(getName()+" "+i);
        }
    }
}
