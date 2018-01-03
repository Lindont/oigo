package com.aos.oigo.Json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2017-12-26
 */
public class JsonTest {

    public Student getData() {
        Student student = new Student();
        student.setId(1);
        student.setNickName("Lindont");
        student.setAge(22);
        student.setEmail("coovoo@vip.qq.com");

        ArrayList<String> books = new ArrayList<>();
        books.add("语文");
        books.add("数学");
        books.add("英语");

        student.setBooks(books);

        HashMap<String, String> booksMap = new HashMap<String, String>();
        booksMap.put("1", "语文");
        booksMap.put("2", "数学");
        booksMap.put("3", "英语");

        return student;
    }

    /**
     * Gson
     * @return
     */

    public String getGsonJson() {
        Student student = getData();
        Gson gson = new Gson();
        String str = gson.toJson(student);
        return str;
    }

    @Test
    public void test2() {
        String str = getGsonJson();
        Gson gson = new Gson();
        Student student = gson.fromJson(str, Student.class);
        System.out.println(student.getId());
        System.out.println(student.getAge());
        System.out.println(student.getNickName());
        System.out.println(student.getEmail());
        System.out.println(student.getBooks());
    }


    @Test
    public void test3() {
        HashMap<String, Book> booksMap = new HashMap<>();
        booksMap.put("book1", new Book(1, "Java"));
        booksMap.put("book2", new Book(2, "Python"));
        booksMap.put("book3", new Book(3, "Kotlin"));

        Gson gson = new Gson();
        String dataStr = gson.toJson(booksMap);
        System.out.println("dataStr:" + dataStr);

        HashMap<String, Book> maps = gson.fromJson(dataStr, new TypeToken<HashMap<String, Book>>() { }.getType());
        maps.forEach((a, b) -> {
            System.out.println(a + " : " + b);
        });
    }


    /**
     * FastJson
     * @return
     */
    public String getFastJson() {
        Student student = getData();
        String str = JSON.toJSONString(student);
        return str;
    }

    @Test
    public void test4() {
        String str = getFastJson();
        JSONObject jsonObject = JSON.parseObject(str);

        Student student = JSONObject.toJavaObject(jsonObject,Student.class);

        System.out.println(student.getId());
        System.out.println(student.getAge());
        System.out.println(student.getNickName());
    }

    @Test
    public void test5() {
        String str = getFastJson();

        Student student = JSON.toJavaObject(JSON.parseObject(str),Student.class);

        System.out.println(student.getId());
        System.out.println(student.getAge());
        System.out.println(student.getNickName());
    }
}
