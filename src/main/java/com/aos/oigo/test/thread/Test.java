package com.aos.oigo.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-02-02
 */
public class Test {

    static class NewThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }


    public static void main(String[] args) {
        new Thread(new NewThread(), "ThreadOne").start();


        FutureTask<Integer> ts = new FutureTask<Integer>((Callable<Integer>) () -> {
            int i = 0;

            return i;
        });
    }
}
