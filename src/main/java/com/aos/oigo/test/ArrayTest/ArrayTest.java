package com.aos.oigo.test.ArrayTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

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
     * 数组排序 及 并发排序
     */
    @Test
    public void test2() {
        int[] a = {0, 5, 8, 9, 6, 4, 3};
        //普通排序
        Arrays.sort(a);
        //并发排序
        int[] b = Arrays.copyOf(a,a.length);
        Arrays.parallelSort(b);
        //将数组转换成字符串
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    /**
     * 数组复制
     */
    @Test
    public void test3() {
        int[] a = {1, 3, 5, 7, 9};
        int[] b = Arrays.copyOf(a, a.length);   //如果超出a的长度, 会用 0 补足
        System.out.println(Arrays.equals(a, b));

        int[] c = Arrays.copyOfRange(a, 0, 3);
        System.out.println(Arrays.toString(c));
    }

    /**
     * 数组赋值
     */
    @Test
    public void test4() {
        int[] a = new int[5];
        //全部赋值
        Arrays.fill(a, 1);
        System.out.println(Arrays.toString(a));
        //部分赋值
        Arrays.fill(a, 0, 3, 2);
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
        int index1 = Arrays.binarySearch(a, 5);
        System.out.println(index1);
        //指定范围搜索
        int index2 = Arrays.binarySearch(a, 0, 2, 3);
        System.out.println(index2);
    }

    /**
     * 数组转成List
     */
    @Test
    public void test6() {
        String[] a = new String[]{"huang", "hao", "xin"};
        List<String> list = Arrays.asList(a);
        list.forEach(System.out::println);
    }

    /**
     * void parallelPrefix(T[] array, BinaryOperator op)
     * void parallelPrefix(T[] array, int fromIndex, int toIndex, BinaryOperator op)
     * <p>
     * BinaryOperator op 为设定的计算公式, 计算公式包括left, right两个形参
     * left代表数组当前索引中前一个元素, right代表当前索引的元素
     * 如果right为数组第一个元素, left默认为1
     */
    @Test
    public void test7() {
        Integer[] arrayTest = {6, 1, 9, 2, 5, 7, 6, 10, 6, 12};
        //操作全部元素
        Arrays.parallelPrefix(arrayTest, (x, y) -> x * y);
        arrayPrint(arrayTest);

        int[] a = {1, 9, 3, 7, 5};
        //操作指定长度的元素
        Arrays.parallelPrefix(a, 0, 3, (x, y) -> {
            return x * y;
        });
        System.out.println(Arrays.toString(a));
    }




    /**
     * 例子
     */
    @Test
    public void test20() {
        int[] arr1 = new int[]{3, -4, 25, 16, 30, 18};
        //并发排序
        Arrays.parallelSort(arr1);
        System.out.println(Arrays.toString(arr1));


        //设置算法操作数组元素
        int[] arr2 = new int[]{3, -4, 25, 16, 30, 18};
        Arrays.parallelPrefix(arr2, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left * right;
            }
        });
        System.out.println(Arrays.toString(arr2));


        //设置生成算法生成数组元素
        int[] arr3 = new int[5];
        Arrays.parallelSetAll(arr3, new IntUnaryOperator() {
            //operand 代表正在计算的元素索引
            @Override
            public int applyAsInt(int operand) {
                return operand * 5;
            }
        });
        System.out.println(Arrays.toString(arr3));
    }



    /**
     * 打印数组
     */
    public void arrayPrint(Object[] object) {
        System.out.println(Arrays.toString(object));
        System.err.println();
    }
}
