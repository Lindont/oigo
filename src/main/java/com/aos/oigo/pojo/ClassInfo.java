package com.aos.oigo.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-19
 */
@Data
public class ClassInfo {
    private int id;
    private String className;
    private int studentCount;
    private List<Student> studentList;
}
