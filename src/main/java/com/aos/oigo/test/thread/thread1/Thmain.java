package com.aos.oigo.test.thread.thread1;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-02-06
 */
public class Thmain {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("aaa");
        }).start();
    }
}
