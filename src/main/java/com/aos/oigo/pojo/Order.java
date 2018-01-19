package com.aos.oigo.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-20
 */
@Data
public class Order {
    private int customerId;
    private String orderCode;
    private Date createtime;
    private String note;
    private Customer customer;
}
