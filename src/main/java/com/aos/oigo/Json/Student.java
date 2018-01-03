package com.aos.oigo.Json;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.HashMap;
import java.util.List;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2017-12-26
 */
@Data
public class Student {
    private int id;
    private String nickName;
    private int age;
    private String email;
    private List<String> books;
    private HashMap<String, String> booksMap;
    private List<Book> book;
}
