package com.aos.oigo.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-19
 */
@Data
public class Student {
    private int id;
    private String name;
    private int age;
    private Date birthday;
    private String address;
}
