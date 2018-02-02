package com.aos.oigo.test;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-02-02
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        System.out.println("main : " + Thread.currentThread().getName());
        ThreadTest1 td = new ThreadTest1();
        new Thread(td,"Thread1").start();
        new Thread(td,"Thread2").start();
    }
}
