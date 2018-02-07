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
public class DiGui {
    public int fn(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 4;
        } else {
            return 2 * fn(n - 1) + fn(n - 2);
        }
    }


    @Test
    public void test() {
        System.out.println(fn(10));
    }
}
