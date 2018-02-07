package com.aos.oigo.test;

/**
 * @Author : HuangHaoXin
 * @Description : 单例模式
 * @Date : Create in 2018-02-07
 */
public class Singleton {
    private static Singleton instance;
    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}
