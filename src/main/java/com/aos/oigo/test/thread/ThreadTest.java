package com.aos.oigo.test.thread;

/**
 * @Author : HuangHaoXin
 * @Description :多线程测试类
 * @Date : Create in 2017-10-13
 */
public class ThreadTest {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();

        Thread2 thread = new Thread2();
        Thread thread2 = new Thread(thread);

        thread1.start();
        thread2.start();
    }
}
