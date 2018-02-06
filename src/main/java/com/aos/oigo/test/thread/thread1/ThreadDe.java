package com.aos.oigo.test.thread.thread1;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-02-06
 */
public class ThreadDe implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i<=100;i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
