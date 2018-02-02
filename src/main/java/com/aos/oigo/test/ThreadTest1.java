package com.aos.oigo.test;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-02-02
 */
public class ThreadTest1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "----- " + i);
        }
    }
}
