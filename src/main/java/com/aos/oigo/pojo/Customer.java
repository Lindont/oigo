package com.aos.oigo.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-20
 */
@Data
public class Customer {
    private int customerId;
    private String customerName;
    private int age;
    private Date birthday;
}
