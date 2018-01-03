package com.aos.oigo.test;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2017-12-14
 */
public class Test3 {
    @Test
    public void test() {
        Long time = 432000000L;
        System.out.println(time);
    }

    @Test
    public void test2() {
        Map map = new HashMap();
        map.put("a", "huang");
        map.put("b", "hao");
        map.put("c", "xin");

        map.forEach((a, b) -> {
            System.out.println("a: " + a + " b: " + b);
        });
    }


    @Test
    public void tes3() {
        String str = "http://www.jb51.net";
        String pattern = "^((https|http|ftp|rtsp|mms)?:\\/\\/)[^\\s]+";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());
    }

    @Test
    public void test4() {
        String[] strArr = new String[]{"huang", "hao", "xin"};
    }

}
