package com.aos.oigo.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2017-11-10
 */
@Slf4j
public class Test2 {
    @Test
    public void test1() {
        int count = 3;
        System.out.println(MessageFormat.format("count:{0}", count));
        log.info("count: {}, message: {}", count, count + 2);
    }
}
