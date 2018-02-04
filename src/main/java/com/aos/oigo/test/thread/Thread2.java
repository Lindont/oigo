package com.aos.oigo.test.thread;

import com.aos.oigo.test.QuickSort;
import com.aos.oigo.test.RandomNumber;

/**
 * @Author : HuangHaoXin
 * @Description :多线程之快速排序
 * @Date : Create in 2017-10-16
 */
public class Thread2 implements Runnable {
    @Override
    public void run() {
        int arr[] = RandomNumber.getRanDomNum();
        QuickSort qs = new QuickSort();
        qs.sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
