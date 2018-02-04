package com.aos.oigo.test.thread;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-02-02
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        System.out.println("main : " + Thread.currentThread().getName());
        RunnableThread rt = new RunnableThread();
        new Thread(rt, "Thread1").start();
        new Thread(rt, "Thread2").start();



        //Lambda表达式创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                for (; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                }
            }
        }, "Thread3").start();
    }
}
