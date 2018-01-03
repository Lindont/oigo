package com.aos.oigo.test;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Paths.get;

/**
 * @Author : HuangHaoXin
 * @Description : IO
 * 读取的文件格式应该是UTF-8格式
 * 如果读入的文件的编码是ANSI编码，在读取文件内容时会报java.nio.charset.MalformedInputException: Input length = 1错误
 * @Date : Create in 2018-01-03
 */
public class IoReadFile {
    @Test
    public void test1() {
        //java 7
        try {
            String str = new String(Files.readAllBytes(get("D:\\new.txt")));
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void test2() {
        try {
            //java 8
            List<String> lines = Files.readAllLines(get("D:\\new.txt"), StandardCharsets.UTF_8);
            StringBuilder sb = new StringBuilder();
            for (String line : lines) {
                sb.append(line);
            }
            String fromFile = sb.toString();
            System.out.println(fromFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test3() throws Exception {
        //java 8 流读取 高效
        try {
            //Files.lines(get("D:\\new.txt"), StandardCharsets.UTF_8).forEach(System.out::println);
            Files.lines(get("D:\\new.txt")).forEach(o -> {
                System.out.println(o);
            });
        } catch (IOException e) {
            throw new Exception("没有找到指定文件");
        }
    }
}
