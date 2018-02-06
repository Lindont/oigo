package com.aos.oigo.test.ArrayTest;

import org.junit.Test;

import java.util.*;

/**
 * @Author : HuangHaoXin
 * @Description : Java8 增强的工具类 Arrays
 * @Date : Create in 2018-02-06
 */
public class ArrayTest {

    /**
     * 对比两个数组是否相等
     */
    @Test
    public void test1() {
        int[] a1 = {1, 3, 5, 7, 9};
        int[] a2 = {1, 3, 5, 7, 9};
        System.out.println(Arrays.equals(a1, a2));
    }


    /**
     * 数组排序
     */
    @Test
    public void test2() {
        int[] a = {0, 5, 8, 9, 6, 4, 3};
        Arrays.sort(a);
        //将数组转换成字符串
        System.out.println(Arrays.toString(a));
    }

    /**
     * 数组复制
     */
    @Test
    public void test3() {
        int[] a = {1, 3, 5, 7, 9};
        int[] b = Arrays.copyOf(a, a.length);   //如果超出a的长度, 会用 0 补足
        System.out.println(Arrays.equals(a, b));

        int[] c = Arrays.copyOfRange(a,0,3);
        System.out.println(Arrays.toString(c));
    }

    /**
     * 数组赋值
     */
    @Test
    public void test4() {
        int[] a = new int[5];
        //全部赋值
        Arrays.fill(a,1);
        System.out.println(Arrays.toString(a));
        //部分赋值
        Arrays.fill(a,0,3,2);
        System.out.println(Arrays.toString(a));
    }

    /**
     * int binarySearch(type[]a , type key)
     * 二分法查询key元素在数组a中出现的索引, 如果数组中不包含key元素, 则返回负数
     * 要求数组中元素已经按升序排列才能得到正确结果
     */
    @Test
    public void test5() {
        int[] a = {1, 9, 3, 7, 5};
        Arrays.sort(a);
        //全范围搜索
        int index1 = Arrays.binarySearch(a,5);
        System.out.println(index1);
        //指定范围搜索
        int index2 = Arrays.binarySearch(a,0,2,3);
        System.out.println(index2);
    }
}
