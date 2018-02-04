package com.aos.oigo.test.thread;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-02-02
 */
public class RunnableThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "----- " + i);
        }
    }
}
