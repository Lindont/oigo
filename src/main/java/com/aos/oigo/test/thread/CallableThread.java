package com.aos.oigo.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author : HuangHaoXin
 * @Description : CallAble 创建线程
 * @Date : Create in 2018-02-02
 */
public class CallableThread {
    public static void main(String[] args) {
        //CallableThread ct = new CallableThread();
        FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>) () -> {
            int i = 0;
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
            return i;
        });


        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            if (i == 20) {
                new Thread(task, "CallAbleThread").start();
            }
        }

        try {
            System.out.println("子线程的返回值: " + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
