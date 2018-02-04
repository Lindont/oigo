package com.aos.oigo.test.thread;

import com.aos.oigo.test.RandomNumber;

/**
 * @Author : HuangHaoXin
 * @Description : 多线程之冒泡排序
 * @Date : Create in 2017-10-16
 */
public class Thread1 extends Thread {
    @Override
    public void run() {
        int[] source = RandomNumber.getRanDomNum();
        for (int i = 0; i < source.length - 1; i++) {
            for (int j = i + 1; j < source.length; j++) {
                if (source[i] < source[j]) {
                    int temp = source[i];
                    source[i] = source[j];
                    source[j] = temp;
                }
            }
        }
        for (int k = 0; k < source.length; k++) {
            System.out.println(getName() + " : " + source[k]);
        }
    }
}
