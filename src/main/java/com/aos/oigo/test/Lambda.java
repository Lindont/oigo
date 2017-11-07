package com.aos.oigo.test;

import org.junit.Test;

import java.util.*;

/**
 * @Author : HuangHaoXin
 * @Description :Lambda表达式
 * @Date : Create in 2017-10-13
 */
public class Lambda
{
    @Test
    public void lambda()
    {
        Collection col = new ArrayList();
        col.add("huang");
        col.add("hao");
        col.add("xin");

        col.forEach(System.out::println);
        System.out.println("");



        Collection col1 = new ArrayList();
        col1.add("huang");
        col1.add("hao");
        col1.add("xin");

        col.forEach(o -> System.out.println(o));
        System.out.println("");



        Collection col2 = new HashSet();
        col2.add("one");
        col2.add("two");
        col2.add("three");

        Iterator it = col2.iterator();
        it.forEachRemaining(p -> System.out.println(p));
        System.out.println("");



        Collection col3 = new HashSet();
        col3.add("one");
        col3.add("two");
        col3.add("three");

        Iterator ite = col3.iterator();
        ite.forEachRemaining((q) -> {
            System.out.println(q);
        });
    }



    @Test
    public void lambda2()
    {
        List<Integer> primes = Arrays.asList(new Integer[]{2,3,5,7});
        int factor = 2;
        primes.forEach(element -> {
            System.out.println(factor*element);
        });
    }
}
